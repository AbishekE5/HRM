/**
 * Provides the necessary information to create Employee controller class
 * To communicate with employee service and employee Dao classes
 */
package com.ideas2it.employee.controller;

import java.sql.SQLException;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;

/**
 * This class controls the flow of the entire employee operations
 */
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();

    /**
     * This method is used to send the user input to create employee details.
     *
     * @param employeeId  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employeeid, phoneNumber, emailID, firstName, lastName
     */
    public Employee createEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        return employeeService.createEmployee(employeeId, phoneNumber, emailID, firstName, lastName);
    }

    /**
     * This method is used to send the user input to delete employee details.
     *
     * @param employeeId This is the  parameter to delete Employee
     * @return emploueeId
     */
    public int deleteEmployee(int employeeId) throws SQLException {
        return employeeService.deleteEmployee(employeeId);
    }

    /**
     * This method is used to validate phone number entered by user.
     *
     * @param phoneNumber
     * @return phoneNumber
     */
    public boolean phoneNumber(String phoneNumber) {
        return employeeService.phoneNumber(phoneNumber);
    }

    /**
     * This method is used to send the user input to create employee details.
     *
     * @param employeeId  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employeeid, phoneNumber, emailID, firstName, lastName
     */
    public Employee updateEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        return employeeService.updateEmployee(employeeId, phoneNumber, emailID, firstName, lastName);
    }

    /**
     * This method is used to retrive employee details.
     *
     * @param employeeId
     * @return employeeId
     */
    public int getEmployeeById(int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
}
