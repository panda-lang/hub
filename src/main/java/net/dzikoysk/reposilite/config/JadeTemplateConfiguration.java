package net.dzikoysk.reposilite.config;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class JadeTemplateConfiguration {

    @Bean
    public SpringTemplateLoader templateLoader() {
        SpringTemplateLoader templateLoader = new SpringTemplateLoader();
        templateLoader.setBasePath("classpath:/WEB-INF/templates/");
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
