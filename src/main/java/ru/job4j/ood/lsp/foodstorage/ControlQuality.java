package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;

import java.util.ArrayList;
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
                break;
            }
        }
        return store;
    }

    public void restore() {
        ArrayList<Food> arrayList = new ArrayList<>();
        for (Store s: this.storeList) {
            arrayList.addAll(s.get());
        }
        for (Food food: arrayList) {
            distribution(food);
        }
    }
}