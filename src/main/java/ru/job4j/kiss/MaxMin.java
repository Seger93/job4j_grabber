package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> biPredicate = (o1, o2) -> comparator.compare(o1, o2) > 0;
        return comp(value, biPredicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> biPredicate = (o1, o2) -> comparator.compare(o1, o2) < 0;
        return comp(value, biPredicate);
    }

    public <T> T comp(List<T> value, BiPredicate<T, T> biPredicate) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Пустая коллекция");
        }
            T res = value.get(0);
            for (T val : value) {
                if (biPredicate.test(val, res)) {
                    res = val;
                }
            }
        return res;
    }
}