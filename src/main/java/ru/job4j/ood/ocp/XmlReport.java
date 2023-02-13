package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlReport implements Report {

    private JAXBContext context;
    private final Store store;
    private final Marshaller marshaller;

    public XmlReport(Store store) {
        this.store = store;
        try {
            context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
            Employees employee = new Employees(store.findBy(filter));
            marshaller.marshal(employee, writer);
            text.append(writer.getBuffer().toString());
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}