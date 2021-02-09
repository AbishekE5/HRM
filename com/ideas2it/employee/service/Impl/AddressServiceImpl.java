/**
 * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public int updateAddress(int addressId, String city, int pincode, String permanentAddress, String temporaryAddress) {
        return addressDaoImpl.updateAddressById(addressId, city, pincode, permanentAddress, temporaryAddress);
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
}
