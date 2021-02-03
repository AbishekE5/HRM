/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fiels
 */
package com.ideas2it.employee.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.ideas2it.employee.controller.AddressController;

public class AddressView {
    AddressController addressController = new AddressController();

    /**
     * This method is used to prompt user to enter menu options.
     */
    public static int menu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new city.");
        System.out.println("2) Delete an city via pincode.");
        System.out.println("3) Retrive an city via pincode.");
        System.out.println("4) Exit.");
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
                    this.addCity();

                    break;
                /* Case to delete the employee details with user input */
                case 2:
                    this.deleteCity();

                    break;

                /* case to retrive data using employee-id */
                case 3:
                    this.updateAddress();
                    break;

                case 4:
                    return;
            }
            menuStore = menu();
        }

    }

    /**
     * This method is used to add a new city
     */
    public void addCity() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Integer addressId = scanner.nextInt();
        System.out.println("Enter addressId");
        String pincode = scanner.nextLine();
        System.out.println("Enter Permanent Address: ");
        String permanentAddress = scanner.nextLine();
        System.out.println("Enter Temporary Address: ");
        String temporaryAddress = scanner.nextLine();
        System.out.println("Enter Temporary Address: ");
        String city = scanner.nextLine();
        System.out.println("City Successfully created");
        addressController.createAddress(addressId, pincode, permanentAddress, temporaryAddress, city);
    }

    /**
     * This method is used to delete a city
     */
    public void deleteCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        int employeeId = scanner.nextInt();
        addressController.deleteAddress(employeeId);
        System.out.println("Employee Successfully deleted");
    }

    /**
     * This method is used to retrive a city
     */
    public void updateAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-id of the employee you wish to retrive: ");
        int employeeId = scanner.nextInt();
        System.out.println("Enter Temporary Address ");
        String pincode = scanner.nextLine();
        System.out.println("Enter Permanent Address: ");
        String permanentAddress = scanner.nextLine();
        System.out.println("Enter Temporary Address: ");
        String temporaryAddress = scanner.nextLine();
        System.out.println("Enter city ");
        String city = scanner.nextLine();
        addressController.updateAddress(employeeId, pincode, permanentAddress, temporaryAddress, city);
    }
}
