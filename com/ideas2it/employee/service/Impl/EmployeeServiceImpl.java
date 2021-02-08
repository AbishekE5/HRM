/**
 * {@inheritDoc}
 */
package com.ideas2it.employee.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employee.dao.Impl.EmployeeDaoImpl;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;
import com.ideas2it.util.Datasource;

/**
 * {@inheritDoc}
 */
public class EmployeeServiceImpl implements EmployeeService {

       EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

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
    public int deleteEmployee(int employeeId) throws SQLException {
        return employeeDao.deleteEmployeeById(employeeId);
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

        /**
         * {@inheritDoc}
         */

    }

    @Override
    public List<Employee> viewEmployee(List<Employee> employee) throws SQLException {
        return null;
    }
}
