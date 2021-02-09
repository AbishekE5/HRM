/**
 * Provides the necessary information to create Employee controller class
 * To communicate with employee service and employee Dao classes
 */
package com.ideas2it.employee.controller;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.Impl.EmployeeServiceImpl;

/**
 * This class controls the flow of the entire employee operations
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
     * This method is used to retrive employee details.
     * @param employeeId
     * @return employeeId
     */
    public Employee getEmployeeById(int employeeId) throws SQLException {
        return employeeService.getEmployeeById(employeeId);
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
}
