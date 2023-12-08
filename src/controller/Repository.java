package controller;

import model.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repository implements Serializable {
    private static List<Employee> employees = new ArrayList<>();

    public static void addEmployee(Employee e) {
        employees.add(e);
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> e){
        employees = e;
    }
}
