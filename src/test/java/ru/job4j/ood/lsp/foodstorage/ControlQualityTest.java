package ru.job4j.ood.lsp.foodstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.model.Food;
import ru.job4j.ood.lsp.foodstorage.tools.FreshnessCalculator;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenRestore() {
        FreshnessCalculator freshnessCalculator = new FreshnessCalculator();
        List<Store> storeList = List.of(new Shop(freshnessCalculator), new Warehouse(freshnessCalculator),
                new Trash(freshnessCalculator));
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food bread = new Food("bread", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(40),
                110, 10);
        Food milk = new Food("milk", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(101),
                110, 10);
        Food salt = new Food("salt", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(-25),
                110, 10);
        Store expected = controlQuality.distribution(bread);
        Store expected1 = controlQuality.distribution(milk);
        Store expected2 = controlQuality.distribution(salt);
        controlQuality.restore();
        assertThat(expected).isInstanceOf(Shop.class);
        assertThat(expected1).isInstanceOf(Trash.class);
        assertThat(expected2).isInstanceOf(Shop.class);
    }
}