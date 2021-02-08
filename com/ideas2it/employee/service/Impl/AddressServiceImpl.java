/**
 * Provide the class necessary information to create address service class
 * To communicate with controller and model classes
 */
package com.ideas2it.employee.service.Impl;

import com.ideas2it.employee.dao.Impl.AddressDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.AddressService;

public class AddressServiceImpl implements AddressService {

    AddressDaoImpl addressDaoImpl = new AddressDaoImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public Address insertAddress(String city, int pincode, String permanentAddress, String temporaryAddress) {
        Address address = new Address(city ,permanentAddress, pincode, temporaryAddress);
        return addressDaoImpl.insertAddress(address);

    }

    /**
     * This method is used to update the address details.
     * @param addressId        This is the first parameter to create Employee
     * @param city             This is the second parameter to create Employee
     * @param pincode          This is the third parameter to createEmployee
     * @param permanentAddress This is the fourth parameter to createEmployee
     * @param temporaryAddress This is the fifth parameter to createEmployee
     * @return addressid, city, pincode, permanentAddress, temporaryAddress
     */

    @Override
    public int updateAddress(int addressId, String city, int pincode, String permanentAddress, String temporaryAddress) {
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

    @Override
    public Address getAddressById(int addressId) {
        return addressDaoImpl.getAddressById(addressId);
    }
}
