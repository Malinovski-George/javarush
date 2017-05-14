package Hibernate_lesson1;
/**
 * Created by Gia on 13.05.2017.
 */
public class Employee {
    Integer employee_id;
    String fio;
    Department department;

    public Employee() {
    }

    public Employee(String fio) {
        this.fio = fio;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}