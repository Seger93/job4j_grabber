package ru.job4j.ood.lsp.foodstorage.tools;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FreshnessCalculator implements Calk<LocalDate> {

    @Override
    public int calculateInPercent(LocalDate startDate, LocalDate endDate) {
        var now = ChronoUnit.DAYS.between(LocalDate.now(), startDate);
        var expired = ChronoUnit.DAYS.between(endDate, startDate);
        return (int) (now * 100 / expired);
    }
}
