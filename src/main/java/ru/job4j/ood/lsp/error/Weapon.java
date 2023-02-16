package ru.job4j.ood.lsp.error;

import java.util.List;
import java.util.Random;

class Weapon {
    protected int caliber;
    protected int damage;
    protected List<String> people;
    /*
    Количество людей для использования оружия.
     */

    public Weapon(int caliber, int damage, List<String> people) {
        this.caliber = caliber;
        this.damage = damage;
        this.people = people;
    }

    public void fire() {
        if (caliber < 0) {
            throw new IllegalArgumentException("Слишком малый калибр");
        }
        if (people.size() < 1) {
            throw new IllegalArgumentException("Слишком мало людей");
        }
        System.out.println(damage);
    }

    public int target(Targ cell, Weapon weapon) {
        int res = 0;
        Random random = new Random();
        if (cell.shield.get(random.nextInt(5)) < (Integer) weapon.damage) {
            res = 1;
        }
        if (cell.shield.get(random.nextInt(5)) >= (Integer) weapon.damage) {
            res = -1;
        }
        return res;
    }
}