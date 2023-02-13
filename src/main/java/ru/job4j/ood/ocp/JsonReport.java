package ru.job4j.ood.ocp;

import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;

    private final GsonBuilder gsonBuilder;

    public JsonReport(Store store, GsonBuilder gsonBuilder) {
        this.store = store;
        this.gsonBuilder = gsonBuilder;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gsonBuilder.create().toJson(store.findBy(filter));
    }
}