package Hibernate_lesson1;

import java.util.HashSet;
import java.util.Set;

/**
 * Отдел
 */
public class Department {
    Integer department_id;
    String caption;

    Set<Employee> employies = new HashSet<Employee>();


    public Department() {
    }

    public Department(String caption) {
        this.caption = caption;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Set<Employee> getEmployies() {
        return employies;
    }

    public void setEmployies(Set<Employee> employies) {
        this.employies = employies;
    }
}
