package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class Parking implements AbstractParking {
    private int[] place;
    private List<Cars> truck = new ArrayList<>();
    private List<Cars> cars = new ArrayList<>();

    @Override
    public void sizePlace(List<Cars> car) {
        int tr = 0;
        int cr = 0;
        for (Cars c : car) {
            if (c.getSize() > 1) {
               this.truck.add(c);
                tr += c.getSize();
            }
            if (c.getSize() <= 1) {
                this.cars.add(c);
                cr += c.getSize();
            }
        }
        this.place = new int[tr + cr];
    }

    public int[] getPlace() {
        return place;
    }

    public List<Cars> getTruck() {
        return truck;
    }

    public List<Cars> getCars() {
        return cars;
    }
}