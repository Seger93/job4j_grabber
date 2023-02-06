package ru.job4j.ood.ocp.errorprincipal;

public class Game {

    public void playGamePC() {
       System.out.println("Im game PC");
    }

    public void playGameConsole() {
        System.out.println("Im game Console");
    }
}

/**
 * Если мы захотим играть в настольную игру, то придется изменить класс, а не расширить его.
 * Так же мы используем этот класс напрямую, без абстракции.
 */