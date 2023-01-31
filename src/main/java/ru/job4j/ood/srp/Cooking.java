package ru.job4j.ood.srp;

public class Cooking {

    private String salt;
    private String sugar;
    private String bread;
    private String oil;
    private static Cooking cooking;

    private Cooking() {
    }

    public static Cooking goCoocking() {
        if (cooking == null) {
            cooking = new Cooking();
        }
        return cooking;
    }
}
