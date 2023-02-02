package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.tools.ReaderCSV;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportCSVTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 1000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        ReaderCSV readerCSV = new ReaderCSV();
        Report report = new ReportCSV(store, parser);
        assertThat(report.generate(em -> true)).isEqualTo(readerCSV.readCSVFile());
    }
}