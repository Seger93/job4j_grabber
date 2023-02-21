package ru.job4j.ood.lsp.foodstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.model.Food;
import ru.job4j.ood.lsp.foodstorage.tools.FreshnessCalculator;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    public void whenInShop() {
        FreshnessCalculator freshnessCalculator = new FreshnessCalculator();
        List<Store> storeList = List.of(new Shop(freshnessCalculator));
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food bread = new Food("bread", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(40),
                110, 10);
        Store expected = controlQuality.distribution(bread);
        assertThat(expected).isInstanceOf(Shop.class);
    }

    @Test
    public void whenNewPrice() {
        FreshnessCalculator freshnessCalculator = new FreshnessCalculator();
        List<Store> storeList = List.of(new Shop(freshnessCalculator));
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food bread = new Food("bread", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(40),
                110, 10);
        Store expected = controlQuality.distribution(bread);
        List<Food> foodList = expected.get();
        int exp = 0;
        for (Food food : foodList) {
            exp = food.getPrice();
        }
        assertThat(100).isEqualTo(exp);
    }
}