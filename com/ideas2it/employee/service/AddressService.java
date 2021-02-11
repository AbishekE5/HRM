/**
 * Provide the interface necessary information to create address service object
 * To communicate with mysql database and to convert the object to table form
 */
package com.ideas2it.employee.service;

import com.ideas2it.employee.model.Address;

import java.sql.SQLException;
import java.util.List;

/**
 * This class performs business logic of the employee details
 */
public interface AddressService {

    /**
     * This method is used to create the address details.
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     */
    public Address insertAddress(String city, int pincode, String permanentAddress, String temporaryAddress ,int employeeId);

    /**
     * This method is used to update the address details.
     * @param employeeId        This is the first parameter to create Employee
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     */
    public int updateAddress(String city, int pincode, String permanentAddress, String temporaryAddress, int employeeId);

    /**
     * This method is used to delete the project details.
     * @param employeeId
     */
    public int deleteAddress(int employeeId);

    /**
     * This method is used to retrieve all address details
     * @param addressId
     * @return
     */
    public Address getAddressById(int addressId);

    /**
     * This methos is used to view all address details
     * @param address
     * @return address
     * @throws SQLException
     */
    public List<Address> viewAllAddress(List<Address> address) throws SQLException;
}
