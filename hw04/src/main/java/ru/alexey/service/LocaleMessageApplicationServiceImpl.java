package ru.alexey.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.alexey.config.ApplicationConfig;

import java.util.Locale;

@Service
public class LocaleMessageApplicationServiceImpl implements LocaleMessageApplicationService {
    private final MessageSource messageSource;
    private final Locale locale;

    public LocaleMessageApplicationServiceImpl(MessageSource messageSource, ApplicationConfig applicationConfig) {
        this.messageSource = messageSource;
        this.locale = applicationConfig.getLocale();
    }

    @Override
    public String localeMessage(String messageKey) {
        return messageSource.getMessage(messageKey, new String[]{}, locale);
    }
}
