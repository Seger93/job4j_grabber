package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Cars;

import java.util.ArrayList;
import java.util.List;

class ParkingTest {

    @Test
    public void whenSizeIsEight() {
        Cars cars = new Cars(1);
        Cars cars1 = new Cars(3);
        Cars cars2 = new Cars(4);
        List<Cars> carsList = new ArrayList<>();
        carsList.add(cars);
        carsList.add(cars1);
        carsList.add(cars2);
        Parking parking = new Parking();
        parking.sizePlace(carsList);
        int[] exp = new int[8];
        Assertions.assertArrayEquals(exp, parking.getPlace());
    }

    @Test
    public void whenSizeTruck() {
        Cars cars = new Cars(1);
        Cars cars1 = new Cars(3);
        Cars cars2 = new Cars(4);
        List<Cars> carsList = new ArrayList<>();
        carsList.add(cars);
        carsList.add(cars1);
        carsList.add(cars2);
        Parking parking = new Parking();
        parking.sizePlace(carsList);
        Assertions.assertEquals(2, parking.getTruck().size());
    }

    @Test
    public void whenSizeCars() {
        Cars cars = new Cars(1);
        Cars cars1 = new Cars(3);
        Cars cars2 = new Cars(4);
        List<Cars> carsList = new ArrayList<>();
        carsList.add(cars);
        carsList.add(cars1);
        carsList.add(cars2);
        Parking parking = new Parking();
        parking.sizePlace(carsList);
        Assertions.assertEquals(1, parking.getCars().size());
    }
}