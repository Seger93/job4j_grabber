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
        CreateParking createParking = new CreateParking(4, 1);
        assertThat(createParking.park(cars2)).isFalse();
    }

    @Test
    public void whenParkIsThue() {
        Car cars2 = new Truck(5);
        CreateParking createParking = new CreateParking(5, 2);
        assertThat(createParking.park(cars2)).isTrue();
    }

    @Test
    public void whenParkTruckIsFalse() {
        Car cars = new Truck(3);
        Car cars1 = new PassengerCar(1);
        Car cars2 = new Truck(5);
        CreateParking createParking = new CreateParking(5, 2);
        createParking.park(cars);
        createParking.park(cars1);
        assertThat(createParking.park(cars2)).isFalse();
    }

    @Test
    public void whenParkPassCarIsFalse() {
        Car cars = new PassengerCar(1);
        Car cars1 = new PassengerCar(1);
        Car cars2 = new PassengerCar(1);
        CreateParking createParking = new CreateParking(5, 2);
        createParking.park(cars);
        createParking.park(cars1);
        assertThat(createParking.park(cars2)).isFalse();
    }
}