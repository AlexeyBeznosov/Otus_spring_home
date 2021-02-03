package ru.alexey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.alexey.config.ApplicationConfig;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class SpringShellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShellApplication.class, args);
    }
}
