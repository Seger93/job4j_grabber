package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {
    public static final int SELECT_DIRECTORY = 1;
    public static final int LOAD_FILE = 2;
    public static final int GET_FILE = 3;
    public static final String MENU = """
                Введите 1 выбор кэшируемой директории.
                Введите 2, чтобы загрузить содержимое файла в кэш.
                Введите 3, чтобы получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DirFileCache cache = null;
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (SELECT_DIRECTORY == userChoice) {
                cache = createCache(cache, scanner);
                System.out.println("Директория выбрана");
            } else if (LOAD_FILE == userChoice) {
                loadData(cache, scanner);
                System.out.print("Содержимое загружено");
                } else if (GET_FILE == userChoice) {
                getData(cache, scanner);
            } else {
                run = false;
                System.out.println("Конец работы");
            }
        }
    }

    private static DirFileCache createCache(DirFileCache cache, Scanner scanner) {
        System.out.println("Укажите полный путь к кэшируемой директории:");
        String dir = scanner.nextLine();
        if (Files.isDirectory(Path.of(dir))) {
            cache = new DirFileCache(dir);
        }
        return cache;
    }

    private static void loadData(DirFileCache cache, Scanner scanner) {
        if (cache == null) {
            System.out.println("Кэш еще не создан. Создайте кэш, выбрав соответствующий пункт меню");
        }
        System.out.println("Введите ключ данных:");
        String key = scanner.nextLine();
        assert cache != null;
        cache.put(key, null);
    }

    private static void getData(DirFileCache cache, Scanner scanner) throws IOException {
        if (cache == null) {
            System.out.println("Кэш еще не создан. Создайте кэш, выбрав соответствующий пункт меню");
            return;
        }
        System.out.println("Введите ключ данных:");
        System.out.println(cache.get(scanner.nextLine()));
    }
}