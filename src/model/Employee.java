package model;

import java.lang.String;

abstract public class Employee {
    private String pesel;
    private String name;
    private String surname;

    private int salary;
    private int phone;

    public Employee(String pesel, String name, String surname, String salary, String phone){
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.salary = Integer.parseInt(salary);
        this.phone = Integer.parseInt(phone);
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
