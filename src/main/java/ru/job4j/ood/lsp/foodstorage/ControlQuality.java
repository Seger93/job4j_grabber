package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;

import java.util.List;

public class ControlQuality {
    private List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Store distribution(Food food) {
        Store store = null;
        for (Store s : storeList) {
            if (s.add(food)) {
                store = s;
            }
        }
        return store;
    }
}