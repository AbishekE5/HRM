package com.ideas2it.employee.view;

import com.ideas2it.employee.controller.AddressController;

import java.sql.SQLException;
import java.util.Scanner;

public class AddressView {
    AddressController controller1 = new AddressController();

    /**
     * This method is used to prompt user to enter menu options.
     */

    public static int menu() {
        System.out.println("Choose one option from following : ");
        System.out.println("1) Add a new city.");
        System.out.println("2) Delete an city via pincode.");
        System.out.println("3) Retrive an city via pincode.");
        System.out.println("4) Exit.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
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
        Scanner scanner1 = new Scanner(System.in);
        String addressId;
        boolean code = true;
        do {
            System.out.println("Enter your pincode ");
            addressId = scanner1.nextLine();
            if (controller1.pincode(addressId)) {
                System.out.println("Entered addressId is Valid");
                break;
            } else {
                System.out.println("Entered city is Invalid... Enter valid city");
            }
        } while (code);

        System.out.println("Enter pincode ");
        String pincode = scanner1.nextLine();
        System.out.println("Enter Permanent Address: ");
        String permanentAddress = scanner1.nextLine();
        System.out.println("Enter Temporary Address: ");
        String temporaryAddress = scanner1.nextLine();
        System.out.println("Enter Temporary Address: ");
        String city = scanner1.nextLine();
        System.out.println("City Successfully created");
        controller1.createAddress(addressId,pincode, permanentAddress, temporaryAddress, city);

    }

    /**
     * This method is used to delete a city
     */

    public void deleteCity() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Please enter the Emp-ID of the employee you wish to delete: ");
        int delete = input2.nextInt();
        controller1.deleteAddress(delete);
        System.out.println("Employee Successfully deleted");
    }


    /**
     * This method is used to retrive a city
     */


    public void updateAddress() {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter the Emp-id of the employee you wish to retrive: ");
        String update = scanner4.nextLine();
        System.out.println("Enter Temporary Address ");
        String pincode = scanner4.nextLine();

        System.out.println("Enter Permanent Address: ");
        String permanentAddress = scanner4.nextLine();

        System.out.println("Enter Temporary Address: ");
        String temporaryAddress = scanner4.nextLine();

        System.out.println("Enter city ");
        String city = scanner4.nextLine();
        controller1.updateAddress(update, pincode, permanentAddress, temporaryAddress);

    }
}
