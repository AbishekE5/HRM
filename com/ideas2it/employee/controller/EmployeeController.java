/**
 * Provides the necessary information to create Employee controller class
 * To communicate with employee service and employee Dao classes
 */
package com.ideas2it.employee.controller;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;

/**
 * This class controls the flow of the entire employee operations
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class EmployeeController {

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    /**
     * This method is used to send the user input to create employee details.
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employeeid, phoneNumber, emailID, firstName, lastName
     */
    public Employee insertEmployee(String phoneNumber, String emailID, String firstName, String lastName) {
        return employeeService.insertEmployee(phoneNumber, emailID, firstName, lastName);
    }

    /**
     * This method is used to insert address details in the address table
     * @param city
     * @param pinCode
     * @param permanent_address
     * @param temporary_address
     * @return city, pinCode, permanent_address, temporary_address
     */
    public Address insertAddress(String city,  int pinCode, String permanent_address, String temporary_address, int employeeId) {
        return employeeService.insertAddress(city, pinCode, permanent_address, temporary_address,employeeId);
    }

    /**
     * This method is used to send the user input to delete employee details.
     * @param employeeId This is the  parameter to delete Employee
     * @return emploueeId
     */
    public int deleteEmployee(int employeeId) throws SQLException {
        return employeeService.deleteEmployee(employeeId);
    }

    /**
     * This method is used to delete the employee personal details
     * @param employeeId
     * @return
     */
    public int deleteAddress(int employeeId) {
        return employeeService.deleteAddress(employeeId);
    }

    /**
     * This method is used to validate phone number entered by user.
     * @param phoneNumber
     * @return phoneNumber
     */
    public boolean validatephoneNumber(String phoneNumber) {
        return employeeService.validatephoneNumber(phoneNumber);
    }

    /**
     * This method is used to send the user input to create employee details.
     * @param employeeId  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employeeid, phoneNumber, emailID, firstName, lastName
     */
    public int updateEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        return employeeService.updateEmployee(employeeId, phoneNumber, emailID, firstName, lastName);
    }

    /**
     * This method is used to update the address details in the address object
     * @param city
     * @param pincode
     * @param permanentAddress
     * @param temporaryAddress
     * @param employeeId
     * @return city, pincode, permanentAddress, temporaryAddress, employeeId
     */
    public int updateAddress(String city, int pincode, String permanentAddress, String temporaryAddress,int employeeId) {
        return employeeService.updateAddress(city, pincode, permanentAddress, temporaryAddress, employeeId);
    }

    /**
     * This method is used to retrieve employee details.
     * @param employeeId
     * @return employeeId
     */
    public Employee getEmployeeById(int employeeId) throws SQLException {
        return employeeService.getEmployeeById(employeeId);
    }

    /**
     * This method is used to retrieve the address details
     * @param addressId
     * @return
     */
    public Address getAddressById(int addressId) {
        return employeeService.getAddressById(addressId);
    }

    /**
     * This method is used to view-all employee details.
     * @param employee
     * @return employee
     * @throws SQLException
     */
    public List<Employee> viewAllEmployee(List<Employee> employee) throws SQLException{
        return employeeService.viewAllEmployee(employee);
    }

    public List<Address> viewAllAddress(List<Address> address) throws SQLException{
        return employeeService.viewAllAddress(address);
    }
}
