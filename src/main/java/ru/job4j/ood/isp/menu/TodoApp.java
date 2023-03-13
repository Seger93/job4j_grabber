package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TodoApp {
    private static final String MENU = """
            "1.Добавить элемент в корень меню"
            "2.Добавить элемент к родительскому элементу"
            "3.Вывод приветствия"
            "4.Печать меню"
            "Для выхода - любая другая цифра"
            """;
    private static final String ASK = "Выберите пункт меню ";
    public static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Привет!");
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new ConsoleMenuPrinter();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        String name;
        while (run) {
            System.out.println(MENU);
            System.out.println(ASK);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Укажите имя элемента: ");
                name = scanner.nextLine();
                menu.add(Menu.ROOT, name, STUB_ACTION);
            } else if (choice == 2) {
                System.out.println("Укажите имя родительского элемента");
                name = scanner.nextLine();
                System.out.println("Укажите имя добавляемого элемента");
                String child = scanner.nextLine();
                menu.add(name, child, STUB_ACTION);
            } else if (choice == 3) {
                DEFAULT_ACTION.delegate();
            } else if (choice == 4) {
                menuPrinter.print(menu);
            } else {
                System.out.println("Программа завершена");
                run = false;
            }
        }
    }
}