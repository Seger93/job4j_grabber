package ru.job4j.kiss;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MaxMinTest {
    private final List<Integer> list = List.of(9, 3, 0, 5, 1, 8, 4);
    private final List<Integer> list1 = List.of();
    private final Comparator<Integer> comparator = Comparator.naturalOrder();
    private final MaxMin result = new MaxMin();

    @Test
    void findMax() {
        assertEquals(result.max(list, comparator), 9);
    }

    @Test
    void findMin() {
        assertEquals(result.min(list, comparator), 0);
    }

    @Test()
    void isEmpty()  {
        assertThatThrownBy(() -> result.max(list1, comparator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пустая коллекция");
    }
}