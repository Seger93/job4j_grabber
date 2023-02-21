package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.model.Food;

import java.util.List;

interface Store {

    boolean add(Food food);

    List<Food> get();

}
