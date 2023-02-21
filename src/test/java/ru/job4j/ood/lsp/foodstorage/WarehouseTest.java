package ru.job4j.ood.lsp.foodstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.model.Food;
import ru.job4j.ood.lsp.foodstorage.tools.FreshnessCalculator;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

@Test
    public void whenInWarehouse() {
        FreshnessCalculator freshnessCalculator = new FreshnessCalculator();
        List<Store> storeList = List.of(new Warehouse(freshnessCalculator));
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food milk = new Food("milk", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(40),
                110, 10);
        Store expected = controlQuality.distribution(milk);
        assertThat(expected).isInstanceOf(Warehouse.class);
    }
}