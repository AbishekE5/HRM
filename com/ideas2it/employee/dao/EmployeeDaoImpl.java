package com.ideas2it.employee.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.util.Datasource;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String INSERT_USERS_SQL = "INSERT INTO employee" + " (employeeID,emailID,firstName,lastName,phoneNumber) VALUES " + " (?,?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "Select employeeID,emailID,firstName,lastName,phoneNumber,status from employee where employeeID =?";

    private static final String SELECT_ALL_USERS = "select * from employee";

    private static final String DELETE_USERS_SQL = "update employee SET status=0  where employeeID = ?;";

    private static final String UPDATE_USERS_SQL = "update employee set  phoneNumber = ?, emailID = ?, firstName = ?, lastName =?  where employeeID = ?";

    /**
     * This method is used to create the employee details.
     * @param employee
     * @return employee
     */
    public Employee addEmployeeDetails(Employee employee) {
        System.out.println(INSERT_USERS_SQL);

        try {

            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, employee.getEmployeeid());
            preparedStatement.setString(2, employee.getEmailid());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getLastname());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return employee;

    }

    /**
     * This method is used to update the employee details.
     * @param  update,phoneNumber, emailID,firstName,lastName
     * @return rowCount
     */
    public int updateEmployee(Integer update,String phoneNumber, String emailID, String firstName, String lastName) {

        int rowCount=0;
        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, emailID);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setInt(5, update);
            rowCount =preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rowCount ;
    }

    /**
     * This method is used to delete the employee details.
     * @param id
     * @return employee
     */

    @Override
    public Employee deleteEmployee(int id) {
        Employee employee = new Employee();

        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employee;
    }
    /**
     * This method is used to Retrive the employee details.
     * @param id
     * @return employee
     */
    public static Employee getEmployeeById(int id) {
        Employee employee = new Employee();

        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                employee.setEmployeeid(rs.getInt(1));
                employee.setPhoneNumber(rs.getString(2));
                employee.setEmailid(rs.getString(3));
                employee.setFirstName(rs.getString(4));
                employee.setLastname(rs.getString(5));
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return employee;
    }
}
