package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

public interface AddressDao {
    public  void addressId(Address address);

    public Address getAddressbyId(int addressId);

    public void updateAddressById(Address address);

    public  void deleteAddressById(Integer addressId);
}
