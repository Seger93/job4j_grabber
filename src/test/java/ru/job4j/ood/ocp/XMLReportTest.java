package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportTest {

    @Test
    public void whenXMLReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new XMLReport(store, parser);
        String s = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(s)
                .append(String.format("<model name=\"%s\">", worker.getName())).append(s)
                .append(String.format("<hired>%s</hired>", parser.parse(worker.getHired()))).append(s)
                .append(String.format("<fired>%s</fired>", parser.parse(worker.getFired()))).append(s)
                .append(String.format("<salary>%s</salary>", worker.getSalary())).append(s)
                .append("</model>").append(s);
        assertThat(engine.generate(em -> true)).isEqualToIgnoringWhitespace(expect.toString());
    }
}