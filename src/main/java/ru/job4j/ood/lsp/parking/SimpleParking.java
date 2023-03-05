package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.PassengerCar;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private int truckPlace;
    private int passengersPlace;
    private List<Car> truck = new ArrayList<>();

    private List<Car> passengersCars = new ArrayList<>();

    public SimpleParking(int truckPlace, int passengersPlace) {
        this.truckPlace = truckPlace;
        this.passengersPlace = passengersPlace;
    }

    @Override
    public boolean park(Car car) {
        boolean rsl = false;
        if (car.getSize() > PassengerCar.SIZE && truckPlace >= car.getSize()) {
            truckPlace = truckPlace - car.getSize();
            truck.add(car);
            return true;
        }
            passengersPlace = passengersPlace - car.getSize();
            passengersCars.add(car);
        return rsl;
    }
}