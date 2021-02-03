package ru.alexey.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class LocalizationConfig {

    @Bean
    public MessageSource messageSource(ApplicationConfig applicationConfig) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/bundle");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
