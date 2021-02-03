package ru.alexey.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationConfig {

    private int valueRightAnswerPass;
    private String fileNameCsv;
    private Locale locale;

    public int getValueRightAnswerPass() {
        return valueRightAnswerPass;
    }

    public void setValueRightAnswerPass(int valueRightAnswerPass) {
        this.valueRightAnswerPass = valueRightAnswerPass;
    }

    public String getFileNameCsv() {
        return fileNameCsv;
    }

    public void setFileNameCsv(String fileNameCsv) {
        this.fileNameCsv = fileNameCsv;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
