/**
 * Provides the necessary information to create Address controller class
 * To communicate with service and Dao classes
 */
package com.ideas2it.employee.controller;

import java.sql.SQLException;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.AddressService;

/**
 * This class controls the flow of the entire employee operations
 */
public class AddressController {
    AddressService addressService = new AddressService();

    /**
     * This method is used to send the user input to create employee details.
     *
     * @param city             This is the first parameter to create Employee
     * @param pincode          This is the second parameter to create Employee
     * @param permanentAddress This is the third parameter to createEmployee
     * @param temporaryAddress This is the fourth parameter to createEmployee
     * @return city, pincode, permanentAddress, temporaryAddress
     */
    public Address createAddress(int addressId, String city, String pincode, String permanentAddress, String temporaryAddress) throws SQLException {
        return addressService.createAddress(addressId, city, pincode, permanentAddress, temporaryAddress);
    }

    /**
     * This method is used to send the user input to create employee details.
     *
     * @param employeeId
     * @return employeeId
     */
    public int deleteAddress(int employeeId) {
        return addressService.deleteAddress(employeeId);
    }

    /**
     * This method is used to update employee details.
     * @param addressId, city, pincode, permanentAddress, temporaryAddress
     * @return addressId, city, pincode, permanentAddress, temporaryAddress
     */
    public int updateAddress(int addressId, String city, String pincode, String permanentAddress, String temporaryAddress) {
        return addressService.updateAddress(addressId, city, pincode, permanentAddress, temporaryAddress);
    }
}
