package com.ideas2it.employee.controller;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.service.AddressService;

import java.sql.SQLException;

public class AddressController {
    AddressService service = new AddressService();

    /**
     * This method is used to send the user input to create employee details.
     * @param city This is the first parameter to create Employee
     * @param pincode This is the second parameter to create Employee
     * @param permanentAddress This is the third parameter to createEmployee
     * @param temporaryAddress This is the fourth parameter to createEmployee
     * @return city, pincode, permanentAddress, temporaryAddress
     */

    public Address createAddress(String city, String pincode, String permanentAddress, String temporaryAddress) throws SQLException {
     return service.createAddress(city,pincode,permanentAddress,temporaryAddress);

    }

    /**
     * This method is used to send the user input to create employee details.
     * @param delete
     * @return delete
     */

    public int deleteAddress(int delete) {

        return service.addressDelete(delete);
    }

    /**
     * This method is used to update employee details.
     *
     * @return update
     */
    public int updateAddress(String city, String pincode, String permanentAddress,String temporaryAddress){
        return service.updateAddress(city,pincode,permanentAddress,temporaryAddress);
    }

    /**
     * This method is used to validate employee details.
     * @param pincode
     * @return retrive
     */

    public boolean pincode(String pincode) {
        return service.pincode(pincode);
    }



}
