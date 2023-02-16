package ru.job4j.ood.lsp.error;

import java.util.List;
import java.util.Random;

class Knife extends Weapon {

    public Knife(int caliber, int damage, List<String> people) {
        super(caliber, damage, people);
    }

    @Override
    public int target(Targ cell, Weapon weapon) {
        int res = 0;
        Random random = new Random();
        if (cell.shield.get(random.nextInt(6)) >= (Integer) weapon.damage) {
            res = 1;
        }
        return res;
    }

    public void message(int i) {
        if (i > 0) {
            System.out.println("Уничтожен");
        }
        if (i < 0) {
            System.out.println("Не хватает урона, выбери другое оружие");
        }
    }

    public static void main(String[] args) {
        List<String> people = List.of("Ivan");
        Targ targ = new Targ();
        Knife knife = new Knife(0, 50, people);
        int res = knife.target(targ, knife);
        knife.message(res);
    }
    /* В методе target убрали проверку на нехватку урона.
    Либо он не будет делать ничего либо уничтожать. Хотя ожидаем предложения изменить оружие.
    Изменили постусловие
     */
}
