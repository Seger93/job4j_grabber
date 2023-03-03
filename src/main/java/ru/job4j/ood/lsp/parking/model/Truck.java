package ru.job4j.ood.lsp.parking.model;

public class Truck extends Car {

    public Truck(int size) {
        super(size);
        if (size <= PassengerCar.SIZE) {
            throw new IllegalStateException("Truck size must be more than 1");
        }
    }
}
