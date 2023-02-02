package ru.job4j.ood.srp.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReaderCSV {
    public String readCSVFile() {
        StringBuilder records = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("report.csv"));) {
            while (scanner.hasNextLine()) {
                records.append(scanner.nextLine())
                        .append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records.toString();
    }
}