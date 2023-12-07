package controller;
import model.*;

import view.WorkersView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static controller.Constants.attributesManager;
import static controller.Constants.attributesSalesman;

public class WorkersController {
    private final WorkersView view;
    Scanner scanForInput;
    public WorkersController(){
        this.view = new WorkersView();
        this.scanForInput = new Scanner(System.in);
    }
    public void start(){
        startMenu();
    }
    private void startMenu(){
        int input;
        do {
            view.printMenu();
            input = scanForInput.nextInt();
            switch (input) {
                case 1:
                    startEmployeeList();
                    break;
                case 2:
                    startAddEmployee();
                    break;
                case 3:
                    startDeleteEmployee();
                    break;
                case 4:
                    startBackup();
                case 9:
                    break;
            }
        } while(input != 9);
    }

    private void startEmployeeList(){

    }

    private void startAddEmployee() {
        try {
            scanForInput.nextLine();
            List<String> employeeData = new ArrayList<>();
            System.out.print("[D]yrektor/[H]andlowiec: ");
            String inputPosition;
            List<String> attributes;
            char pos;

            do {
                inputPosition = scanForInput.nextLine();
                pos = inputPosition.toCharArray()[0];
            }while (!Validation.validatePosition(inputPosition));

            if (pos == 'D'){
                attributes = attributesManager;
            }
            else {
                attributes = attributesSalesman;
            }

           for (String attribute: attributes) {
               System.out.print("Podaj " + attribute + ": ");
               employeeData.add(scanForInput.nextLine());
           }

           if(pos == 'D'){
               if (Validation.validateManager(employeeData)){
                   Employee manager = new Manager(
                           employeeData.get(0),
                           employeeData.get(1),
                           employeeData.get(2),
                           employeeData.get(3),
                           employeeData.get(4),
                           employeeData.get(5),
                           employeeData.get(6),
                           employeeData.get(7)
                   );
                   Repository.addEmployee(manager);
               }
           }
           else{
               if(Validation.validateSalesman(employeeData)){
                   Employee salesman = new Salesman(
                           employeeData.get(0),
                           employeeData.get(1),
                           employeeData.get(2),
                           employeeData.get(3),
                           employeeData.get(4),
                           employeeData.get(5),
                           employeeData.get(6)
                   );
                   Repository.addEmployee(salesman);
               }
           }


        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }

    private void startDeleteEmployee(){

    }

    private  void startBackup(){

    }
}
