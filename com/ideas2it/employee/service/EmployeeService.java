/**
 * Provide the class necessary information to create service class
 * To communicate with controller and model classes
 */
package com.ideas2it.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/**
 * This class performs business logic of the employee details
 */
public interface EmployeeService {

    /**
     * This method is used to create the employee details.
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employee
     */
    public Employee insertEmployee(String phoneNumber, String emailID, String firstName, String lastName);

    /**
     * This method is used to delete the employee details.
     * @param employeeId
     * @return employeeId
     */
    public int deleteEmployee(int employeeId) throws SQLException;

    /**
     * This method is used to update the employee details.
     * @param employeeId  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employee
     */
    public int updateEmployee(int employeeId, String phoneNumber, String emailID, String firstName, String lastName);

    /**
     * This method is used to validate phone number
     * @param phoneNumber
     * @return true, false
     */
    public boolean validatephoneNumber(String phoneNumber);

    /**
     *  This method is used to retrieve the employee details
     * @param employeeId
     * @return employeeId
     */
    public Employee getEmployeeById(int employeeId) throws SQLException;

    /**
     * This method is used to view-all the employee details
     * @param employee
     * @return
     * @throws SQLException
     */
    public List<Employee> viewAllEmployee(List<Employee> employee) throws SQLException;

    /**
     * This method is used to view all address details
     * @param address
     * @return
     * @throws SQLException
     */
    public List<Address> viewAllAddress(List<Address> address) throws SQLException;

}
