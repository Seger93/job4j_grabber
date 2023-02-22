package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractStore implements Store {

    private final List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (productVerification(food)) {
            foodList.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(foodList);
    }

    boolean productVerification(Food food) {
        return false;
    }
}