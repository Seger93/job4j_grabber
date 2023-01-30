package ru.job4j.ood.srp;

import java.time.LocalDateTime;

public interface Forecast {
    LocalDateTime time();

    String weather();

    void print(LocalDateTime time, String cur);
}
