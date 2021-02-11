/**
 * Provides the necessary information to create Address Dao interface class
 * To communicate with the sql server database and to convert the address object to table
 */
package com.ideas2it.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.model.Address;

/**
 * This interface method implements Address Dao class
 */
public interface AddressDao {

    /**
     * This method is used to create address details in the address table
     * @param
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
    public int updateAddressById(String city, int pincode, String permanentAddress, String temporaryAddress, int addressId);

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

    /**
     * This method is to view all employee details in the address table
     * @param address
     * @return
     * @throws SQLException
     */
    public List<Address> viewAllAddress(List<Address> address) throws SQLException;
}
