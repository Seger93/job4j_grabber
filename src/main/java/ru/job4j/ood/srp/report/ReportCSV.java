package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.function.Predicate;
public class ReportCSV implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportCSV(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
            StringBuilder text = new StringBuilder();
            text.append("Name; Hired; Fired; Salary;")
                    .append(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                text.append(employee.getName()).append(" ")
                        .append(dateTimeParser.parse(employee.getHired())).append(" ")
                        .append(dateTimeParser.parse(employee.getFired())).append(" ")
                        .append(employee.getSalary())
                        .append(System.lineSeparator());
            }
            try (PrintWriter writer = new PrintWriter("report.csv")) {
            writer.write(text.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return text.toString();
    }
}