package net.dzikoysk.reposilite.config;

import de.neuland.jade4j.*;
import de.neuland.jade4j.spring.template.*;
import de.neuland.jade4j.spring.view.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class JadeTemplateConfiguration {

    @Bean
    public SpringTemplateLoader templateLoader() {
        SpringTemplateLoader templateLoader = new SpringTemplateLoader();
        templateLoader.setBasePath("/WEB-INF/templates/");
        templateLoader.setSuffix(".jade");
        return templateLoader;
    }

    @Bean
    public JadeConfiguration jadeConfiguration() {
        JadeConfiguration configuration = new JadeConfiguration();
        configuration.setCaching(false);
        configuration.setTemplateLoader(this.templateLoader());
        return configuration;
    }

    @Bean
    public ViewResolver viewResolver() {
        JadeViewResolver viewResolver = new JadeViewResolver();
        viewResolver.setConfiguration(this.jadeConfiguration());
        return viewResolver;
    }

}
