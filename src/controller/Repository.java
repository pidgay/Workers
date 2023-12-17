package controller;

import model.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repository implements Serializable {
    private static List<Employee> employees;

    public Repository(){
        Repository.employees = new ArrayList<>();
    }

    public Repository(List<Employee> employees){
        Repository.employees = employees;
    }

    public static void addEmployee(Employee e) {
        employees.add(e);
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> e){
        Repository.employees = e;
    }
}
