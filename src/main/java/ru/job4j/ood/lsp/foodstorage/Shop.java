package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;
import ru.job4j.ood.lsp.foodstorage.tools.FreshnessCalculator;

public class Shop extends AbstractStore {

    private FreshnessCalculator calculator;

    public Shop(FreshnessCalculator calculator) {
        this.calculator = calculator;
    }

     boolean productVerification(Food food) {
        boolean res = false;
        int fresh = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        if (fresh >= 25 && fresh < 75) {
            res = true;
        }
        if (fresh < 75) {
            newPrice(food);
            res = true;
        }
        return res;
    }

    private void newPrice(Food food) {
        food.setPrice(food.getPrice() - food.getDiscount());
    }
}