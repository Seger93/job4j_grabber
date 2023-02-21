package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;
import ru.job4j.ood.lsp.foodstorage.tools.FreshnessCalculator;

public class Warehouse extends AbstractStore {
    private FreshnessCalculator calculator;

    public Warehouse(FreshnessCalculator calculator) {
        this.calculator = calculator;
    }

     boolean productVerification(Food food) {
        int fresh = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return fresh <= 25;
    }
}