/**
 * Provide the class necessary information to create address service class
 * To communicate with controller and model classes
 */

package com.ideas2it.employee.service;

import com.ideas2it.employee.dao.DaoImpl.AddressDaoImpl;
import com.ideas2it.employee.model.Address;

public class AddressService {
    AddressDaoImpl addressDaoImpl = new AddressDaoImpl();

    /**
     * This method is used to create the address details.
     *
     * @param addressId        This is the first parameter to create Employee
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     * @return address
     */
    public Address createAddress(Integer addressId, String city, String pincode, String permanentAddress, String temporaryAddress) {
        Address address = new Address(addressId, city, pincode, permanentAddress, temporaryAddress);
        return addressDaoImpl.addAddressId(address);
    }

    /**
     * This method is used to update the address details.
     *
     * @param addressId        This is the first parameter to create Employee
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     * @return addressid, city, pincode, permanentAddress, temporaryAddress
     */
    public int updateAddress(int addressId, String city, String pincode, String permanentAddress, String temporaryAddress) {
        return addressDaoImpl.updateAddressById(addressId, city, pincode, permanentAddress, temporaryAddress);
    }

    /**
     * This method is used to delete the project details.
     * @param employeeId
     * @return employeeId
     */
    public int deleteAddress(int employeeId) {
        return addressDaoImpl.deleteAddressById(employeeId);
    }
}
