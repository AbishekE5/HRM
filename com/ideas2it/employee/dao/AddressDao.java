/**
 * Provides the necessary information to create Address Dao interface class
 * To communicate with the sql server database and to convert the address object to table
 */
package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;

/**
 * This interface method implements Address Dao class
 */
public interface AddressDao {

    /**
     * This method is used to create address details in the address table
     * @param address
     * @return address
     */
    public Address insertAddress(Address address);

    /**
     * This method is used to update address details in the address table
     * @param addressId
     * @param city
     * @param pincode
     * @param permanentAddress
     * @param temporaryAddress
     * @return rowCount
     */
    public int updateAddressById(int addressId, String city, int pincode, String permanentAddress, String temporaryAddress);

    /**
     * This method is used to delete employee details in the employee table
     * @param addressId
     * @return addressId
     */
    public int deleteAddressById(int addressId);

    /**
     * This method is used to delete employee details in the employee table
     * @param addressId
     * @return
     */
    public Address getAddressById(int addressId);
}
