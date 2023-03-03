package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.PassengerCar;
import ru.job4j.ood.lsp.parking.model.Truck;
import static org.assertj.core.api.Assertions.*;

class ParkingTest {

    @Test
    public void whenParkIsFalse() {
        Car cars2 = new Truck(5);
        SimpleParking simpleParking = new SimpleParking(4, 1);
        assertThat(simpleParking.park(cars2)).isFalse();
    }

    @Test
    public void whenParkIsThue() {
        Car cars2 = new Truck(5);
        SimpleParking simpleParking = new SimpleParking(5, 2);
        assertThat(simpleParking.park(cars2)).isTrue();
    }

    @Test
    public void whenParkTruckIsFalse() {
        Car cars = new Truck(3);
        Car cars1 = new PassengerCar();
        Car cars2 = new Truck(5);
        SimpleParking simpleParking = new SimpleParking(5, 2);
        simpleParking.park(cars);
        simpleParking.park(cars1);
        assertThat(simpleParking.park(cars2)).isFalse();
    }

    @Test
    public void whenParkPassCarIsFalse() {
        Car cars = new PassengerCar();
        Car cars1 = new PassengerCar();
        Car cars2 = new PassengerCar();
        SimpleParking simpleParking = new SimpleParking(5, 2);
        simpleParking.park(cars);
        simpleParking.park(cars1);
        assertThat(simpleParking.park(cars2)).isFalse();
    }
}