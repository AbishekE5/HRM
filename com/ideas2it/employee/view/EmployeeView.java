/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */

package com.ideas2it.employee.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.ideas2it.employee.controller.EmployeeController;
import com.ideas2it.employee.model.Employee;

/**
 * This class interacts with the user of employee details
 */
public class EmployeeView {

    EmployeeController employeeController = new EmployeeController();

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
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * This method is used to perform the CRUD operations
     */
    public void performCrud() throws SQLException {
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
                    return;
            }
            menuStore = menu();
        }
    }

    /**
     * This method is used to add a new employee
     */
    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        boolean number = true;
        do {
            System.out.println("Enter Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (employeeController.phoneNumber(phoneNumber)) {
                System.out.println("Entered Number is Valid");
                break;
            } else {
                System.out.println("Entered Number is Invalid... Enter valid Number");
            }
        } while (number);
        System.out.println("Enter a employee Id: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter EmailID ");
        String emailID = scanner.nextLine();
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        employeeController.createEmployee(employeeId, phoneNumber, emailID, firstName, lastName);
        System.out.println("Employee Successfully created");
    }

    /**
     * This method is used to perform the delete operations
     */
    public void deleteEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        int employeeId = scanner.nextInt();
        employeeController.deleteEmployee(employeeId);
        System.out.println("Employee Successfully deleted");
    }

    /**
     * This method is used to perform the retrieve operations
     */
    public void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-id of the employee you wish to update: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter new EmailID ");
        String emailID = scanner.nextLine();
        System.out.println("Enter new First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter new Last Name: ");
        String lastName = scanner.nextLine();
        Employee employee = employeeController.updateEmployee(employeeId, phoneNumber, emailID, firstName, lastName);
        System.out.println(employee);
    }
}
