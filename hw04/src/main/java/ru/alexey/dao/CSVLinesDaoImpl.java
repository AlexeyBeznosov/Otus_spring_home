package ru.alexey.dao;

import org.springframework.stereotype.Component;
import ru.alexey.config.ApplicationConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CSVLinesDaoImpl implements CSVLinesDao {

    private final ApplicationConfig applicationConfig;
    private List<String> lines;

    public CSVLinesDaoImpl(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Override
    public List<String> getAllCSVLines() {
        if (lines != null ) {
            return lines;
        }
        String fileName = applicationConfig.getFileNameCsv();
        BufferedReader questionBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
        lines = questionBufferedReader.lines().collect(Collectors.toList());
        return lines;
    }
}
