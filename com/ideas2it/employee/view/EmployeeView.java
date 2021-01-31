package com.ideas2it.employee.view;

import java.util.Scanner;
import com.ideas2it.employee.controller.EmployeeController;
import com.ideas2it.employee.model.Employee;


public class EmployeeView {
    EmployeeController controller = new EmployeeController();

    /**
     * This method is used to prompt user to enter menu options.
     */
    public static int menu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new employee.");
        System.out.println("2) Delete an employee via Emp-ID.");
        System.out.println("3) update an employee via Emp-ID.");
        System.out.println("4) retrive an employee via Emp-ID. ");
        System.out.println("5) exit");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * This method is used to perform the CRUD operations
     */

    public void performCrud() {

        int menuStore = menu();
        while (menuStore != 5) {
            System.out.println();

            switch (menuStore) {

                /* switch statement to create employee details */
                case 1:
                    this.addEmployee();

                    break;
                /* Case to delete the employee details with user input */
                case 2:
                    this.deleteEmployee();

                    break;

                /* case to retrive data using employee-id */
                case 3:
                    this.updateEmployee();
                    break;


                case 4:
                    this.retriveEmployee();
                    break;

                case 5:
                    return;
            }
            menuStore = menu();
        }


    }

    private void retriveEmployee() {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter the Emp-id of the employee you wish to retrive: ");
        Integer retrive= scanner4.nextInt();
        Employee e2 = controller.getEmployeeById(retrive);
        System.out.println(e2);
    }


    /**
     * This method is used to add a new employee
     */
    public void addEmployee(){
        Scanner scanner1 = new Scanner(System.in);


        String phoneNumber;
        boolean number = true;
        do {
            System.out.println("Enter Phone Number: ");
            phoneNumber = scanner1.nextLine();
            if (controller.phoneNumber(phoneNumber)){
                System.out.println("Entered Number is Valid");
                break;
            } else{
                System.out.println("Entered Number is Invalid... Enter valid Number");
            }
        }while(number);

        System.out.println("Enter a employeeid: ");
        Integer employeeid = Integer.parseInt(scanner1.nextLine());
        System.out.println("Enter EmailID ");
        String emailID = scanner1.nextLine();
        System.out.println("Enter First Name: ");
        String firstName = scanner1.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner1.nextLine();

        controller.createEmployee(employeeid,phoneNumber,emailID,firstName,lastName);

        System.out.println("Employee Successfully created");
    }
    /**
     * This method is used to perform the delete operations
     */

    public void deleteEmployee(){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        Integer delete = scanner2.nextInt();
        controller.deleteEmployee(delete);
        System.out.println("Employee Successfully deleted");
    }
    /**
     * This method is used to perform the retrive operations
     */
    public void updateEmployee() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Please enter the Emp-id of the employee you wish to update: ");
        Integer update= Integer.parseInt(scanner3.nextLine());
        System.out.println("Enter new Phone Number");
        String phoneNumber= scanner3.nextLine();
        System.out.println("Enter new EmailID ");
        String emailID = scanner3.nextLine();
        System.out.println("Enter new First Name: ");
        String firstName = scanner3.nextLine();
        System.out.println("Enter new Last Name: ");
        String lastName = scanner3.nextLine();

        int e1 = controller.updateEmployee(update,phoneNumber,emailID,firstName,lastName);
        System.out.println(e1);

    }
}
