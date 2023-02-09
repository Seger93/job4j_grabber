package ru.job4j.ood.ocp.errorprincipal;

import java.util.LinkedList;
import java.util.List;
public class Bibl {

    private Book book;

    private List<Book> books = new LinkedList<>();

    //Возвратит абстракцию
    public static List<Object> autor(String name) {
        return null;
    }

    //метод принимает и возвращает объект - будет мешать наследованию.
    public static Bibl biblGen(Book book) {
        return new Bibl();
    }
}
