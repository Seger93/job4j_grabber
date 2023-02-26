package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CreateParking implements Parking {

    private int truckPlace;
    private int passengersPlace;
    private List<Car> truck = new ArrayList<>();

    private List<Car> passengersCars = new ArrayList<>();

    public CreateParking(int truckPlace, int passengersPlace) {
        this.truckPlace = truckPlace;
        this.passengersPlace = passengersPlace;
    }

    @Override
    public boolean park(Car car) {
        boolean rsl = false;
        if (car.getSize() > 1 && truckPlace >= car.getSize()) {
            truckPlace = truckPlace - car.getSize();
            rsl = truck.add(car);
        }
        if (car.getSize() <= 1 && passengersPlace >= car.getSize()) {
            passengersPlace = passengersPlace - car.getSize();
            rsl = passengersCars.add(car);
        }
        return rsl;
    }
}