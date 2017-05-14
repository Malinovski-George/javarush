package Hibernate_lesson1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Gia on 13.05.2017.
 */
public class main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session ses = factory.openSession();

        ses.beginTransaction();

        Employee jim = new Employee("jim");
        Employee tom = new Employee("tom");
        Employee ron = new Employee("ron");
        Department managers = new Department("managers");
        Department designers = new Department("designers");

        managers.getEmployies().add(jim);
        managers.getEmployies().add(tom);
        managers.getEmployies().add(ron);

        jim.setDepartment(managers);
        tom.setDepartment(managers);
        ron.setDepartment(managers);

      //  ses.saveOrUpdate(managers);
        ses.saveOrUpdate(designers);
        ses.saveOrUpdate(jim);
     //   ses.saveOrUpdate(tom);
     //   ses.saveOrUpdate(ron);

        ses.getTransaction().commit();

        System.out.println("------------------------------------------");
        // ---------------------------
        ses.beginTransaction();

        Department managers_2 = (Department) ses.load(Department.class, 1);
        Department designers_2 = (Department) ses.load(Department.class, 2);
        Employee[] employies = managers_2.getEmployies().toArray(
                new Employee[]{});

        for (Employee employy : employies) {
            managers_2.getEmployies().remove(employy);
            designers_2.getEmployies().add(employy);
            employy.setDepartment(designers_2);
        }
        ses.delete(managers_2);
        ses.getTransaction().commit();
    }
}
