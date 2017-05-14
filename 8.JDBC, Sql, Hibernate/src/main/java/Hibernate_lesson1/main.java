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
        Department managers = new Department("managers");
        managers.getEmployies().add(jim);
        jim.setDepartment(managers);

        ses.saveOrUpdate(managers);
        ses.saveOrUpdate(jim);

        ses.getTransaction().commit();
    }
}
