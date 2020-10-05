/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.jline.utils.AttributedString
import org.jline.utils.AttributedStyle
import org.panda_lang.utilities.commons.StringUtils
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.shell.jline.PromptProvider
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.io.File

@Configuration
@EnableMongoRepositories
internal class HubConfiguration : WebMvcConfigurer {

    @Bean
    fun workspaceDirectory(@Value("\${hub.workspace}") workspace: String?): File {
        return File(StringUtils.replace(workspace, "/", File.separator))
    }

    @Bean
    fun resourcesDirectory(@Qualifier("workspaceDirectory") workspace: File?): File {
        return File(workspace, "resources")
    }

    @Bean
    fun shellPrompt(): PromptProvider {
        return PromptProvider { AttributedString("hub:> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN)) }
    }

    @Bean
    fun messageSource(): MessageSource {
        return ReloadableResourceBundleMessageSource().also {
            it.setBasename("classpath:message")
            it.setDefaultEncoding("UTF-8")
        }
    }

    @Bean
    @Primary
    fun localValidatorFactoryBean(): LocalValidatorFactoryBean {
        return LocalValidatorFactoryBean().also {
            it.setValidationMessageSource(messageSource())
        }
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "PATCH", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600)
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/resources/**")
            .addResourceLocations("classpath:/resources/")
            .resourceChain(false)
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().also {
            it.registerModule(JavaTimeModule())
            it.registerModule(Jdk8Module())
            it.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        }
    }
}
