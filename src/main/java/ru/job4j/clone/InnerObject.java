package ru.job4j.clone;

public class InnerObject implements Cloneable {
    int num;

    @Override
    public InnerObject clone() {
        try {
            InnerObject clone = (InnerObject) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
