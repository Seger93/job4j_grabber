package ru.job4j.ood.isp.menu;

public class ConsoleMenuPrinter implements MenuPrinter {

    private static final String INDENT = "----";

    @Override
    public void print(Menu menu) {
        menu.forEach(menuItemInfo -> {
            int indentCount = menuItemInfo.getNumber().split("\\.").length - 1;
            for (int i = 1; i <= indentCount; i++) {
                System.out.print(INDENT);
            }
            System.out.println(menuItemInfo.getNumber() + menuItemInfo.getName());
        });
    }
}