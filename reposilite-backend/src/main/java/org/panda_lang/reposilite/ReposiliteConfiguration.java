/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.panda_lang.panda.utilities.commons.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
class ReposiliteConfiguration implements WebMvcConfigurer {

    @Bean
    public File workspaceDirectory(@Value("${reposilite.workspace}") String workspace) {
        return new File(StringUtils.replace(workspace, "/", File.separator));
    }

    @Bean
    public File repositoriesDirectory(@Qualifier("workspaceDirectory") File workspace) {
        return new File(workspace, "repositories");
    }

    @Bean
    public File mavenRepositoryDirectory(@Qualifier("repositoriesDirectory") File repositories) {
        return new File(repositories, "maven");
    }

    @Bean
    public PromptProvider shellPrompt() {
        return () -> new AttributedString("reposilite:> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN));
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    @Primary
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(this.messageSource());
        return factoryBean;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "PATCH", "DELETE")
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type")
                .exposedHeaders("Location")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/")
                .resourceChain(false);
    }

}
