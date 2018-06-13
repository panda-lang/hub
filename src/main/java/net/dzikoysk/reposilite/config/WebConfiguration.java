package net.dzikoysk.reposilite.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/script/**")
                .addResourceLocations("/resources/static/script/");

        registry.addResourceHandler("/static/style/**")
                .addResourceLocations("/resources/static/style/");

        registry.addResourceHandler("/static/views/**")
                .addResourceLocations("/resources/static/views/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("/resources/static/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}