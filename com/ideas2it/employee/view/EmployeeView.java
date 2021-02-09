/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */
package com.ideas2it.employee.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("2) Delete an employee via Employee-ID.");
        System.out.println("3) retrieve an employee via Employee-ID.");
        System.out.println("4) update an employee via Employee-ID. ");
        System.out.println("5) view all employees");
        System.out.println("6) Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * This method is used to perform the CRUD operations
     */
    public void performCrud() throws SQLException {
        int menuStore = menu();
        while (menuStore !=6) {
            System.out.println();
            switch (menuStore) {
                case 1:
                    this.insertEmployeeById();
                    break;

                case 2:
                    this.deleteEmployee();
                    break;

                case 3:
                    this.getEmployeeById();
                    break;

                case 4:
                    this.updateEmployee();
                    break;

                case 5:
                    this.viewAllEmployee();
                    break;

                case 6:
                    return;
            }
            menuStore = menu();
        }
    }

    /**
     * This method is used to add a new employee
     */
    public void insertEmployeeById() {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        boolean number = true;
        do {
            System.out.println("Enter Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (employeeController.validatephoneNumber(phoneNumber)) {
                System.out.println("Entered Number is Valid");
                break;
            } else {
                System.out.println("Entered Number is Invalid... Enter valid Number");
            }
        } while (number);
        System.out.println("Enter EmailID ");
        String emailID = scanner.next();
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        Employee employee =employeeController.insertEmployee(phoneNumber, emailID, firstName, lastName);
        System.out.println("Employee Successfully created...  Employee ID is " + employee.getEmployeeid());
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
     * This method is used to perform the update operations
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
        int employee = employeeController.updateEmployee(employeeId, phoneNumber, emailID, firstName, lastName);
        System.out.println(employee);
    }

    /**
     * This method is used to perform the retrieve operations
     */
    public void getEmployeeById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to retrieve: ");
        int employeeId = scanner.nextInt();
        Employee employee=employeeController.getEmployeeById(employeeId);
        if (employee==null){
            System.out.println("Employee does not exists");
        }
        else {
            System.out.println(employee);
        }

    }

    /**
     * This method is used to perform the view-all employee operations
     */
    public void viewAllEmployee() throws SQLException {
        List<Employee> employee = new ArrayList<Employee>();
        employee =employeeController.viewAllEmployee(employee);
        System.out.println(employee);
    }
}

