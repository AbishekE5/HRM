/**
 * Provide the class necessary information to create service class
 * To communicate with controller and model classes
 */
package com.ideas2it.employee.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;

/**
 * This class performs the business logic operations of the employee
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class EmployeeServiceImpl implements EmployeeService {

       EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
       AddressServiceImpl addressService = new AddressServiceImpl();

    /**
     * {@inheritDoc}
     */
    public Employee insertEmployee(String phoneNumber, String emailID, String firstName, String lastName) {
        Employee employee = new Employee(phoneNumber, emailID, firstName, lastName);
        return employeeDao.insertEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public Address insertAddress(String city, int pinCode, String permanentAddress, String temporaryAddress, int employeeId){
        return addressService.insertAddress(city , pinCode, permanentAddress, temporaryAddress, employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public int deleteEmployee(int employeeId) throws SQLException {
        return employeeDao.deleteEmployeeById(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public int deleteAddress(int employeeId){
        return addressService.deleteAddress(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public int updateEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        return employeeDao.updateEmployeeById(employeeId, phoneNumber, emailID, firstName, lastName);
    }

    /**
     * {@inheritDoc}
     */
    public int updateAddress(String city,int pincode, String permanentAddress, String temporaryAddress, int addressId){
        return addressService.updateAddress(city, pincode, permanentAddress, temporaryAddress, addressId);
    }

    /**
     * {@inheritDoc}
     */
    public boolean validatephoneNumber(String phoneNumber) {
        String number = "\\d{10}";
        //Creating a pattern object
        Pattern pattern = Pattern.compile(number);
        //Creating a Matcher object
        Matcher matcher = pattern.matcher(phoneNumber);
        //Verifying whether given phone number is valid
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public Employee getEmployeeById(int employeeId) throws SQLException {
        return employeeDao.getEmployeeById(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public Address getAddressById(int addressId) {
        return addressService.getAddressById(addressId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> viewAllEmployee(List<Employee> employee) throws SQLException {
        return employeeDao.viewAllEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> viewAllAddress(List<Address> address) throws SQLException {
        return addressService.viewAllAddress(address);
    }
}
