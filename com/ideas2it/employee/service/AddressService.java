/**
 * Provide the interface necessary information to create address service object
 * To communicate with mysql database and to convert the object to table form
 */
package com.ideas2it.employee.service;

import com.ideas2it.employee.model.Address;

public interface AddressService {

    /**
     * This method is used to create the address details.
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     */
    public Address insertAddress(String city, int pincode, String permanentAddress, String temporaryAddress);

    /**
     * This method is used to update the address details.
     * @param addressId        This is the first parameter to create Employee
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     */
    public int updateAddress(int addressId,String city, int pincode, String permanentAddress, String temporaryAddress);

    /**
     * This method is used to delete the project details.
     * @param employeeId
     */
    public int deleteAddress(int employeeId);

    /**
     *
     * @param addressId
     * @return
     */
    public Address getAddressById(int addressId);
}
