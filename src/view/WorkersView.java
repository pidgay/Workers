package view;
import model.*;

public class WorkersView {
    public void printMenu(){
        System.out.println("MENU");
        System.out.println("\t1. LISTA PRACOWNIKÓW");
        System.out.println("\t2. DODAJ PRACOWNIKA");
        System.out.println("\t3. USUŃ PRACOWNIKA");
        System.out.println("\t4. KOPIA ZAPASOWA");
        System.out.println("WYBÓR>");
    }
    public void printEmployeeList(Employee employee){
        System.out.println("1. LISTA PRACOWNIKÓW");
        printEmployee(employee);
        System.out.println("\t\t\t\t" + "[Pozycja: " + " "+ "/" + "]");
        System.out.println("[ENTER] - następny");
        System.out.println("[Q] - powrót");
    }

    public void printEmployee(Employee employee){
        System.out.println("\t Identyfikator PESEL\t" + ":\t" + employee.getPesel());
        System.out.println("\t Imię\t" + ":\t" + employee.getName());
        System.out.println("\t Nazwisko\t" + ":\t" + employee.getSurname());
        System.out.println("\t Stanowisko\t" + ":\t" + employee.getClass().getName());
        System.out.println("\t Wynagrodzenie (zł)\t" + ":\t" + employee.getSalary());
        System.out.println("\t Telefon służbowy numer\t" + ":\t" + employee.getPhone());
        if (employee instanceof Manager) {
            System.out.println("\t Dodatek służbowy (zł)\t" + ":\t" + ((Manager)employee).getBonus());
            System.out.println("\t Karta służbowa numer\t" + ":\t" + ((Manager)employee).getCard());
            System.out.println("\t Limit kosztów/miesiąc (zł)\t" + ":\t" + ((Manager)employee).getCardLimit());
        }
        else if (employee instanceof Salesman){
            System.out.println("\t Prowizja (%)\t" + ":\t" + ((Salesman)employee).getCommission());
            System.out.println("\t Limit prowizji/miesiąc (zł)\t" + ":\t" + ((Salesman)employee).getCommissionLimit());
        }
    }

}
