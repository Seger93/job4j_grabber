package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;
import ru.job4j.ood.lsp.foodstorage.tools.FreshnessCalculator;

public class Trash extends AbstractStore {
    private FreshnessCalculator calculator;

    public Trash(FreshnessCalculator calculator) {
        this.calculator = calculator;
    }

     protected boolean productVerification(Food food) {
        int fresh = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return fresh >= 0;
    }
}
