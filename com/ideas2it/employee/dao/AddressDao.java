/**
 * Provides the necessary information to create Address Dao interface class
 * To communicate with the sql server database and to convert the address object to table
 */

package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;

public interface AddressDao {

    /**
     * This method is used to create address details in the address table
     */
    public Address addAddressId(Address address);

    /**
     * This method is used to update address details in the address table
     */
    public int updateAddressById(int addressId, String city, String pincode, String permanentAddress, String temporaryAddress);

    /**
     * This method is used to delete employee details in the employee table
     */
    public int deleteAddressById(int delete);

}
