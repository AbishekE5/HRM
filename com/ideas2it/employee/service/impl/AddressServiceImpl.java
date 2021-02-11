/**
 * {@inheritDoc}
 */
package com.ideas2it.employee.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.dao.impl.AddressDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.AddressService;
/**
 * This class performs the business logic operations of the address
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class AddressServiceImpl implements AddressService {

    AddressDaoImpl addressDaoImpl = new AddressDaoImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public Address insertAddress(String city, int pincode, String permanent_address, String temporary_address, int employeeId) {
        Address address = new Address(city, pincode, permanent_address, temporary_address, employeeId);
        return addressDaoImpl.insertAddress(address);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateAddress(String city, int pincode, String permanentAddress, String temporaryAddress,int employeeId) {
        return addressDaoImpl.updateAddressById(city, pincode, permanentAddress, temporaryAddress,employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public int deleteAddress(int employeeId) {
        return addressDaoImpl.deleteAddressById(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address getAddressById(int addressId) {
        return addressDaoImpl.getAddressById(addressId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> viewAllAddress(List<Address> address) throws SQLException {
        return addressDaoImpl.viewAllAddress(address);
    }
}
