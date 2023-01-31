package ru.job4j.ood.srp;

import java.util.Objects;

public class Cars {
    private  String model;
    private  String wheels;
    private  String color;
    private  String body;

    public Cars(String model, String wheels, String color, String body) {
        this.model = model;
        this.wheels = wheels;
        this.color = color;
        this.body = body;
    }

    public String getModel() {
        return model;
    }

    public String getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public String getBody() {
        return body;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void reColor(String color, Cars cars) {
        cars.setColor(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars that = (Cars) o;
        return Objects.equals(model, that.model)
                && Objects.equals(wheels, that.wheels)
                && Objects.equals(color, that.color)
                && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, wheels, color, body);
    }

    @Override
    public String toString() {
        return "Cars{"
                + "model='" + model + '\''
                + ", wheels='" + wheels + '\''
                + ", color='" + color + '\''
                + ", body='" + body + '\''
                + '}';
    }
}