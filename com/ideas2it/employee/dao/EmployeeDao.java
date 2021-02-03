/**
 * Provides the necessary information to create Employee Dao Implementation class
 * To communicate with the sql server database and to convert the employee object to table
 */

package com.ideas2it.employee.dao;

import java.sql.SQLException;

import com.ideas2it.employee.model.Employee;

/**
 * This interface method implements Employee
 */
public interface EmployeeDao {

    /**
     * This method is used to create employee details in the employee table
     */
    public Employee addEmployeebyId(Employee employee);

    /**
     * This method is used to update employee details in the employee table
     */
    public int updateEmployeeById(int employeeId, String phoneNumber, String emailID, String firstName, String lastName);

    /**
     * This method is used to delete employee details in the employee table
     */
    public int deleteEmployeeById(int employeeId) throws SQLException;

    /**
     * This method is used to retrieve employee details in the employee table
     */
    public int getEmployeeById(int employeeId) throws SQLException;
}
