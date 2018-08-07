package net.dzikoysk.reposilite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;

@EnableWebMvc
@Configuration
public class ReposiliteConfiguration {

    @Bean
    public File getRepositoriesDirectory() {
        return new File("repositories");
    }

}
