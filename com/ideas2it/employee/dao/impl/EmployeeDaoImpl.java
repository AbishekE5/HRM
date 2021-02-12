/**
 * Provides the necessary information to create Address Dao interface class
 * To communicate with the sql server database and to convert the address object to table
 */
package com.ideas2it.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.util.Datasource;

/**
 * This class establishes the database connectivity with the sql server
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private final String INSERT_USERS_SQL = "INSERT INTO employee (emailID, firstName, lastName, phoneNumber) VALUES (?,?,?,?);";
    private final String SELECT_USER_BY_ID = "Select employeeID, emailID, firstName, lastName, phoneNumber from employee where employeeID =?";
    private final String SELECT_ALL_USERS = "Select employeeID, emailID, firstName, lastName, phoneNumber from employee";
    private final String SELECT_AUTO_ID = "(select max(employeeID) from employee)";
    private final String DELETE_USERS_SQL = "update employee SET status=0  where employeeID = ?;";
    private final String UPDATE_USERS_SQL = "update employee set  emailID = ?, firstName = ?, lastName =?, phoneNumber=?  where employeeID = ?";

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee insertEmployee(Employee employee) {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, employee.getEmailId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastname());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.executeUpdate();
            preparedStatement= connection.prepareStatement(SELECT_AUTO_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee.setEmployeeid(resultSet.getInt("max(employeeID)"));
        } catch (Exception exception) {
            exception.printStackTrace(); }
        return employee;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateEmployeeById(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        int rowCount = 0;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1,emailID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setInt(5, employeeId);
            rowCount = preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return rowCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteEmployeeById(int employeeId) throws SQLException {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employeeId;
    }

    /**
     * {@inheritDoc}
     */
    public Employee getEmployeeById(int employeeId) {
        Employee employee= null;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeid(resultSet.getInt(1));
                employee.setPhoneNumber(resultSet.getString(2));
                employee.setEmailId(resultSet.getString(3));
                employee.setFirstName(resultSet.getString(4));
                employee.setLastName(resultSet.getString(5));
                connection.close();
                return employee;
            }
            else {
                return employee;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> viewAllEmployee(List<Employee> employee) throws SQLException {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt(1);
                String phoneNumber = resultSet.getString(2);
                String emailId = resultSet.getString(3);
                String firstName = resultSet.getString(4);
                String lastName = resultSet.getString(5);
                employee.add(new Employee(employeeId, phoneNumber, emailId, firstName, lastName));
            }
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return employee;
    }
}
