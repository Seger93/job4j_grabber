package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Cars;

import java.util.List;

public class Parking implements AbstractParking {
    private List<Cars> truck;
    private List<Cars> cars;
    private int[] place;

    public Parking(int[] place) {
        this.place = place;
    }

    @Override
    public void sizePlace() {
    }
}