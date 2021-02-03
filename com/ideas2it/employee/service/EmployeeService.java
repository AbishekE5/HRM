/**
 * Provide the class necessary information to create service class
 * To communicate with controller and model classes
 */
package com.ideas2it.employee.service;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employee.dao.DaoImpl.EmployeeDaoImpl;
import com.ideas2it.employee.model.Employee;

/**
 * This class performs business logic of the employee details
 */
public class EmployeeService {
    EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    /**
     * This method is used to create the employee details.
     * @param employeeId  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employee
     */
    public Employee createEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        Employee employee = new Employee(employeeId, phoneNumber, emailID, firstName, lastName);
        return employeeDao.addEmployeebyId(employee);
    }

    /**
     * This method is used to delete the employee details.
     * @param employeeId
     * @return employeeId
     */
    public int deleteEmployee(int employeeId) throws SQLException {
        return employeeDao.deleteEmployeeById(employeeId);
    }

    /**
     * This method is used to create the employee details.
     * @param employeeId  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employee
     */
    public Employee updateEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        Employee employee = new Employee(employeeId, phoneNumber, emailID, firstName, lastName);
        return employeeDao.addEmployeebyId(employee);
    }

    /**
     * This method is used to validate phone number
     * @param phoneNumber
     * @return true, false
     */
    public boolean phoneNumber(String phoneNumber) {
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
     *  This method is used to retrive the employee details
     * @param employeeId
     * @return employeeId
     */
    public int getEmployeeById(int employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }
}
