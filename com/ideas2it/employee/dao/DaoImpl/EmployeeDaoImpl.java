/**
 * Provides the necessary information to create Employee Dao Implementation class
 * To communicate with the sql server database and to convert the employee object to table
 */

package com.ideas2it.employee.dao.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.util.Datasource;

/**
 * This class  handles database informations of employee details in persistance logic
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private final String INSERT_USERS_SQL = "INSERT INTO employee" + " (emailID, firstName, lastName, phoneNumber) VALUES " + " (?,?,?,?,?);";

    private final String SELECT_USER_BY_ID = "Select employeeID, emailID, firstName, lastName, phoneNumber, status from employee where employeeID =?";

    private final String SELECT_ALL_USERS = "select employeeID, emailID, firstName, lastName, phoneNumber, status from employee";

    private final String DELETE_USERS_SQL = "update employee SET status=0  where employeeID = ?;";

    private static final String UPDATE_USERS_SQL = "update employee set  phoneNumber = ?, emailID = ?, firstName = ?, lastName =?  where employeeID = ?";

    /**
     * This methos is to create employee details in the employee table
     * @param employee
     * @return employee
     */
    @Override
    public Employee addEmployeebyId(Employee employee) {
        System.out.println(INSERT_USERS_SQL);
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, employee.getEmailId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastname());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    /**
     * This method is used to update employee details in the employee table
     * @param employeeId
     * @param phoneNumber
     * @param emailID
     * @param firstName
     * @param lastName
     * @return rowCount
     */
    @Override
    public int updateEmployeeById(int employeeId, String phoneNumber, String emailID, String firstName, String lastName) {
        int rowCount = 0;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, emailID);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setInt(5, employeeId);
            rowCount = preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowCount;
    }

    /**
     * This method is used to delete employee details in the employee table
     * @param employeeId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteEmployeeById(int employeeId) throws SQLException {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeId;
    }

    /**
     * This method is used to retrieve employee details in the employee table
     * @param employeeId
     * @return employeeId
     */
    public int getEmployeeById(int employeeId) {
        Employee employee = new Employee();
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                employee.setEmployeeid(rs.getInt(1));
                employee.setPhoneNumber(rs.getString(2));
                employee.setEmailId(rs.getString(3));
                employee.setFirstName(rs.getString(4));
                employee.setLastName(rs.getString(5));
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employeeId;
    }
}
