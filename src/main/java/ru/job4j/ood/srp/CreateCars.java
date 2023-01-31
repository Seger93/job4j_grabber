package ru.job4j.ood.srp;

public class CreateCars {
    private final String model;
    private final String wheels;
    private final String color;
    private final String body;

    public CreateCars(String model, String wheels, String color, String body) {
        this.model = model;
        this.wheels = wheels;
        this.color = color;
        this.body = body;
    }

    public CreateCars create(String model, String wheels, String color, String body) {
        return new CreateCars(model, wheels, color, body);
    }

    public boolean sailCar(CreateCars car, int price, Owner owner) {
        boolean rsl =  false;
        if (price < owner.getMoney()) {
            owner.byCar(car);
        }
        return rsl;
    }
}