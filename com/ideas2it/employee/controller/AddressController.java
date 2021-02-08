/**
 * Provides the necessary information to create Address controller class
 * To communicate with service and Dao classes
 */
package com.ideas2it.employee.controller;

import java.sql.SQLException;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.Impl.AddressServiceImpl;

/**
 * This class controls the flow of the entire address operations
 */
public class AddressController {

    AddressServiceImpl addressService = new AddressServiceImpl();

    /**
     * This method is used to send the user input to create employee details.
     *
     * @param city             This is the first parameter to create Employee
     * @param pincode          This is the second parameter to create Employee
     * @param permanentAddress This is the third parameter to createEmployee
     * @param temporaryAddress This is the fourth parameter to createEmployee
     * @return city, pincode, permanentAddress, temporaryAddress
     */
    public Address insertAddress(String city,  String permanentAddress, String temporaryAddress,int pincode) throws SQLException {
        return addressService.insertAddress(city,  pincode, permanentAddress, temporaryAddress);
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
     *
     * @param addressId, city, pincode, permanentAddress, temporaryAddress
     * @return addressId, city, pincode, permanentAddress, temporaryAddress
     */
    public int updateAddress(int addressId, String city, int pincode, String permanentAddress, String temporaryAddress) {
        return addressService.updateAddress(addressId, city, pincode, permanentAddress, temporaryAddress);
    }

    /**
     * This method is used to get the address details.
     *
     * @param addressId
     * @return
     */
    public Address getAddressById(int addressId) {
        return addressService.getAddressById(addressId);
    }

}
