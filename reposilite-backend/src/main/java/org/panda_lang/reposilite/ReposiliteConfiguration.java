package org.panda_lang.reposilite;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.panda_lang.panda.utilities.commons.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.File;
import java.util.List;

@Configuration
class ReposiliteConfiguration extends WebMvcConfigurationSupport {

    private final ApplicationContext applicationContext;

    @Autowired
    public ReposiliteConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

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
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "PATCH", "DELETE")
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type")
                .exposedHeaders("Location")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/")
                .resourceChain(false);
    }

    @Override
    protected void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setOneIndexedParameters(true);
        argumentResolvers.add(resolver);
        super.addArgumentResolvers(argumentResolvers);
    }

}
