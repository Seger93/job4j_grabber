package ru.job4j.ood.srp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class GenerateForecast implements Forecast {

    @Override
    public LocalDateTime time() {
        return LocalDateTime.now();
    }

    @Override
    public String weather() {
        Random random = new Random();
        List<String> one = List.of("--Снегодождь / +0", "--Дождь / +3", "--Снег /  -2",
                "--Солнце / +5");
        return one.get(random.nextInt(one.size()));
    }

    @Override
    public void print(LocalDateTime time, String cur) {
        System.out.printf("\n%s%s", time, cur);
    }

    public static void main(String[] args) {
        var generateForecast = new GenerateForecast();
        generateForecast.print(generateForecast.time(), generateForecast.weather());
    }
}
