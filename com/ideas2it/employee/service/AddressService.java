package com.ideas2it.employee.service;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ideas2it.employee.dao.AddressDaoImpl;
import com.ideas2it.employee.model.Address;



public class AddressService {
    AddressDaoImpl dao = new AddressDaoImpl();

        /**
         * This method is used to create the employee details.
         * @param city This is the first parameter to create Employee
         * @param pincode  This is the second parameter to create Employee
         * @param permanentAddress  This is the third parameter to createEmployee
         * @param temporaryAddress This is the fourth parameter to createEmployee
         * @return city,pincode,permanentAddress,temporaryAddress
         */
        public Address createAddress(String city, String pincode, String permanentAddress,String temporaryAddress) throws SQLException {
        Address address = new Address(city, pincode, permanentAddress, temporaryAddress);
        return dao.createAddress(address);

    }
        /**
         * This method is used to delete the employee details.
         * @param delete This is the first parameter to create Employee
         * @return delete
         */
        public int addressDelete(int delete) {
            return dao.deleteAddress(delete);


    }
    public int updateAddress(String city, String pincode, String permanentAddress,String temporaryAddress){
            return dao.updateAddress(city,pincode,permanentAddress,temporaryAddress);
    }

        /**
         * This method is used to check the employee details.
         * @param pincode
         * @return true,false
         */
        public boolean pincode(String pincode) {
        String number = "\\d{6}";

        //Creating a pattern object
        Pattern pattern = Pattern.compile(number);
        //Creating a Matcher object
        Matcher matcher = pattern.matcher(pincode);
        //Verifying whether given phone number is valid
        if (matcher.matches()) {
            return true;

        } else {
            return false;
        }
    }
}
