package controller;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static final List<Employee> employees = new ArrayList<>();

    public static void addEmployee(Employee e) {
        employees.add(e);
    }

    public static List<Employee> getEmployees() {
        return employees;
    }
}
