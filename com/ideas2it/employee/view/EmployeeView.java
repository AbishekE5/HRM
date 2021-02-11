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
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/**
 * This class interacts with the user of employee details
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class EmployeeView {

    EmployeeController employeeController = new EmployeeController();
    public static int menu(){
        System.out.println("Choose any option from below");
        System.out.println("1) Enter Employee Personal Details");
        System.out.println("2) Enter Employee Project Details");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void PerforMenuOption() throws SQLException {
        int menuOptionStore= menu();
        while (menuOptionStore!=2){
            switch (menuOptionStore){
                case 1:
                    this.performCrud();
                    return;
            }
        }
    }
    /**
     * This method is used to prompt user to enter menu options.
     */
    public static int EmployeeMenu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new employee.");
        System.out.println("2) Delete an employee via Employee-ID.");
        System.out.println("3) retrieve an employee via Employee-ID.");
        System.out.println("4) update an employee via Employee-ID. ");
        System.out.println("5) view all employees");
        System.out.println("6) Add address of employee");
        System.out.println("7) delete address details");
        System.out.println("8) retrieve address details");
        System.out.println("9) update address details");
        System.out.println("10) view all address details");
        System.out.println("11) Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * This method is used to perform the CRUD operations
     */
    public void performCrud() throws SQLException {
        int menuStore = EmployeeMenu();
        while (menuStore !=11) {
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
                    this.insertAddress();
                    break;

                case 7:
                    this.deleteAddress();
                    break;

                case 8:
                    this.getAddressById();
                    break;

                case 9:
                    this.updateAddress();
                    break;

                case 10:
                    this.viewAllAddress();
                    break;

                case 11:
                    return;
            }
            menuStore = EmployeeMenu();
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
        System.out.println("Please enter the Employee-ID of the employee you wish to update: ");
        int employeeId = scanner.nextInt();
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
        System.out.println("Successfully updated");
    }

    /**
     * This method is used to perform the retrieve operations
     */
    public void getEmployeeById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Employee-ID of the employee you wish to retrieve: ");
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

    /**
     * This method is used to perform the view-all address operations
     * @throws SQLException
     */
    public void viewAllAddress() throws SQLException {
        List<Address> address = new ArrayList<Address>();
        address = employeeController.viewAllAddress(address);
        System.out.println(address);
    }

    /**
     * This method is used to add a new address
     */
    public void insertAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city");
        String city = scanner.next();
        System.out.println("Enter pincode ");
        int pinCode = scanner.nextInt();
        System.out.println("Enter permanent address");
        String permanent_address = scanner.next();
        System.out.println("Enter temporary address ");
        String temporary_address = scanner.next();
        System.out.println("Enter employeeId ");
        int employeeId = scanner.nextInt();
        Address address =employeeController.insertAddress(city, pinCode, permanent_address, temporary_address, employeeId);
        System.out.println("Address successfully inserted... Address ID is " + address.getAddressId());
    }

    /**
     * This method is used to delete a city
     */
    public void deleteAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        int employeeId = scanner.nextInt();
        employeeController.deleteAddress(employeeId);
        System.out.println("Employee Successfully deleted");
    }

    /**
     * This method is used to retrieve address
     */
    public void getAddressById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to retrieve: ");
        int addressId = scanner.nextInt();
        Address address =employeeController.getAddressById(addressId);
        if(address == null){
            System.out.println("Address Id not found");
        }
        else{
            System.out.println(address);
        }
        System.out.println("Address successfully retrieved");
    }

    /**
     * This method is used to update address
     */
    public void updateAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Employee-ID of the employee you wish to update: ");
        int addressId = scanner.nextInt();
        System.out.println("Enter a new city ");
        String city = scanner.next();
        System.out.println("Enter a new pincode ");
        int pincode = scanner.nextInt();
        System.out.println("Enter Permanent address ");
        String permanentAddress = scanner.next();
        System.out.println("Enter Temporary address ");
        String temporaryAddress = scanner.next();
        employeeController.updateAddress(city, pincode, permanentAddress, temporaryAddress, addressId);
        System.out.println("Successfully updated");
    }
}

