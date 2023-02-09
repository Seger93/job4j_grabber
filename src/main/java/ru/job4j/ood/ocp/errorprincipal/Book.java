package ru.job4j.ood.ocp.errorprincipal;

import java.util.Random;

public class Book {
    private String autor;
    private String price;
    private int genre;
    //Абстрактное поле класса.
    private Random random;

    public Book(String autor, String price, int genre, Random random) {
        this.autor = autor;
        this.price = price;
        this.genre = genre;
        this.random = random;
    }

    public String getAutor() {
        return autor;
    }

    public String getPrice() {
        return price;
    }

    public int getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{"
                + "autor='" + autor + '\''
                + ", price='" + price + '\''
                + ", genre='" + genre + '\''
                + '}';
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
}
