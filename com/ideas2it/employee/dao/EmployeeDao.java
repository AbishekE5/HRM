/**
 * Provides the necessary information to create Employee Dao Implementation class
 * To communicate with the sql server database and to convert the employee object to table
 */
package com.ideas2it.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.model.Employee;

/**
 * This interface method implements Employee Dao Class
 */
public interface EmployeeDao {

    /**
     * This method is used to insert employee details in the employee table
     *
     * @param employee
     * @return employee
     */
    public Employee insertEmployee(Employee employee);

    /**
     * This method is used to update employee details in the employee table
     *
     * @param employeeId
     * @param phoneNumber
     * @param emailID
     * @param firstName
     * @param lastName
     * @return employeeId , phoneNumber ,emailID , firstName, lastName
     */
    public int updateEmployeeById(int employeeId, String phoneNumber, String emailID, String firstName, String lastName);

    /**
     * This method is used to delete employee details in the employee table
     *
     * @param employeeId
     * @return employeeId
     * @throws SQLException
     */
    public int deleteEmployeeById(int employeeId) throws SQLException;

    /**
     * This method is used to retrieve employee details with in the employee table
     * @param employeeId
     * @return employeeId
     * @throws SQLException
     */
    public Employee getEmployeeById(int employeeId) throws SQLException;

    /**
     * This method is used to view-all employee details with in the employee table
     * @param employee
     * @return
     * @throws SQLException
     */
    public List<Employee> viewEmployee(List<Employee> employee) throws SQLException;
}

