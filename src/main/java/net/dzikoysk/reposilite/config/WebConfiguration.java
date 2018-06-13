package net.dzikoysk.reposilite.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/static/js/**")
                .addResourceLocations("/resources/static/js/");

        registry.addResourceHandler("/assets/static/css/**")
                .addResourceLocations("/resources/static/css/");

        registry.addResourceHandler("/assets/static/views/**")
                .addResourceLocations("/resources/static/views/");

        registry.addResourceHandler("/assets/static/**")
                .addResourceLocations("/resources/static/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}