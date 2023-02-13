package ru.job4j.ood.ocp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XmlReportTest {
    @Test
    public void whenXMLReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new XmlReport(store);
        String expected = String.format("""  
                        <Employees>
                            <employee name="%s" salary="%s">
                                <hired>%s</hired>
                                <fired>%s</fired>
                            </employee>
                        </Employees>""", worker.getName(),
                worker.getSalary(), parser.parse(worker.getHired()), parser.parse(worker.getFired()));
        assertThat(engine.generate(em -> true)).isEqualToIgnoringWhitespace(expected);
    }
}