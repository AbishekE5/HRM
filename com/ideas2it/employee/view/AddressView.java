/**
 * Provide the class necessary information to create address view class
 * To communicate with the user to get input fields
 */
package com.ideas2it.employee.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.ideas2it.employee.controller.AddressController;
import com.ideas2it.employee.model.Address;

public class AddressView {

    AddressController addressController = new AddressController();

    /**
     * This method is used to prompt user to enter menu options.
     */
    public static int menu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new address.");
        System.out.println("2) Delete a address via address-id");
        System.out.println("3) update a address via address-id.");
        System.out.println("4) retrieve a address via address-id.");
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
                case 1:
                    this.insertAddress();
                    break;

                case 2:
                    this.deleteAddress();
                    break;

                case 3:
                    this.updateAddress();
                    break;

                case 4:
                    this.getAddressById();
                    break;

                case 5:
                    return;
            }
            menuStore = menu();
        }
    }

    /**
     * This method is used to add a new city
     */
    public void insertAddress() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();
        System.out.println("Enter a city");
        String permanentAddress = scanner.next();
        System.out.println("Enter permanent address");
        String temporaryAddress = scanner.next();
        System.out.println("Enter temporary adress ");
        int pinCode = scanner.nextInt();
        System.out.println("Enter pincode ");
        Address address =addressController.insertAddress(city ,permanentAddress, temporaryAddress, pinCode);
        System.out.println("Address successfully inserted... Address ID is" + address.getAddressId());
    }

    /**
     * This method is used to delete a city
     */
    public void deleteAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        int employeeId = scanner.nextInt();
        addressController.deleteAddress(employeeId);
        System.out.println("Employee Successfully deleted");
    }

    /**
     * This method is used to retrieve a city
     */
    public void updateAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-id of the employee you wish to retrive: ");
        int employeeId = scanner.nextInt();
        System.out.println("Enter Temporary Address ");
        int pincode = scanner.nextInt();
        System.out.println("Enter Permanent Address: ");
        String permanentAddress = scanner.next();
        System.out.println("Enter Temporary Address: ");
        String temporaryAddress = scanner.next();
        System.out.println("Enter city ");
        String city = scanner.next();
        addressController.updateAddress(employeeId,  permanentAddress,  pincode ,temporaryAddress, city);
    }

    /**
     * This method is used to delete a city
     */
    public void getAddressById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        int addressId = scanner.nextInt();
        Address address =addressController.getAddressById(addressId);
        if(address == null){
            System.out.println("Address Id not found");
        }
        else{
            System.out.println(address);
        }
        System.out.println("Address successfully retrieved");
    }

}
