package org.panda_lang.reposilite;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@EnableWebMvc
@Configuration
public class ReposiliteConfiguration implements WebMvcConfigurer {

    @Bean
    public File mavenRepositoryDirectory() {
        return new File("repositories" + File.separator + "maven");
    }

    @Bean
    public PromptProvider shellPrompt() {
        return () -> new AttributedString("reposilite:> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "PATCH", "DELETE");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Primary
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(this.messageSource());

        return factoryBean;
    }

}
