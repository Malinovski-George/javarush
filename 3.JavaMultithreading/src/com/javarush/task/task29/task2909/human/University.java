package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    String name;
    int age;

    private List<Student> students = new ArrayList();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List getStudents() {
        return students;
    }

    public void setStudents(List students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {

        Student rezultStuident = null;
        for (Student student : students
                ) {
            if (student.getAverageGrade() == averageGrade) {
                rezultStuident = student;
                break;
            }
        }
        return rezultStuident;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student rezultStuident = null;
        double averageGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() >= averageGrade) {
                averageGrade = student.getAverageGrade();
            }
        }
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                rezultStuident = student;
                break;
            }
        }
        return rezultStuident;
    }

    public Student getStudentWithMinAverageGrade() {
        Student rezultStuident = null;
        double averageGrade = 10000;
        for (Student student : students) {
            if (student.getAverageGrade() <= averageGrade) {
                averageGrade = student.getAverageGrade();
            }
        }
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                rezultStuident = student;
                break;
            }
        }
        return rezultStuident;
    }

    public void expel(Student student) {
        students.remove(student);

    }


}