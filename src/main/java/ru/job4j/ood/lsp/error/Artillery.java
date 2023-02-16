package ru.job4j.ood.lsp.error;

import java.util.List;
class Artillery extends Weapon {
    public Artillery(int caliber, int damage, List<String> people) {
        super(caliber, damage, people);
    }

    public void fire(List<String> people) {
        if (people.size() < 3) {
            throw new IllegalArgumentException("Слишком мало людей");
        }
        System.out.println(damage);
    }

    public static void main(String[] args) {
        List<String> people = List.of("Ivan");
        Artillery artillery  = new Artillery(155, 400, people);
        artillery.fire(people);
    }
    /*
     На одно орудие нужно как минимум 3 человека в то время как для винтовки например нужен один. Предусловие усилено.
     */
}