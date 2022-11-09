package ru.job4j.grabber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HabrCareerDateTimeParser implements DateTimeParser {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Override
    public LocalDateTime parse(String parse) {
        return LocalDateTime.parse(parse, FORMATTER);
    }
}
