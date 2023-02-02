package ru.job4j.ood.srp.tools;

import ru.job4j.ood.srp.model.Employee;
import java.util.Comparator;

public class CompareHR implements Comparator<Employee> {

    @Override
    public int compare(Employee o, Employee b) {
        return Double.compare(b.getSalary(), o.getSalary());
    }
}