package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Employee;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/employee?useSSL=false";
    private String jdbcUsername = "adminuser";
    private String jdbcPassword = "element5@123";

    private static final String INSERT_USERS_SQL = "INSERT INTO employee" + " (emloyeeID,EmailID,firstName,lastName,phoneNumber) VALUES " + " (?,?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "Select emloyeeID,phoneNumber,EmailID,firstName,lastName from employee where emloyeeID =?";

    private static final String SELECT_ALL_USERS = "select * from employee";

    private static final String DELETE_USERS_SQL = "update employee SET status=0  where emloyeeid = ?;";

    private static final String UPDATE_USERS_SQL = "update employee set PhoneNumber = ? EmailID = ? FirstName = ? LastName = ? where id = ?";

    public static Connection getConnection() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "adminuser", "element5@123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }


    public Employee addEmployeeDetails(Employee employee) {
        System.out.println(INSERT_USERS_SQL);

        try {
            Connection connection = getConnection();
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


    public Employee updateEmployee(int id) {
        Employee employee = new Employee();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);

            preparedStatement.setString(1, employee.getPhoneNumber());
            preparedStatement.setString(2, employee.getEmailid());
            preparedStatement.setString(3, employee.getFirstName());
            preparedStatement.setString(4, employee.getLastname());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return employee;
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee employee = new Employee();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return employee;


    }

    public static Employee getEmployeeById(int id) {
        Employee employee = new Employee();

        try {
            Connection connection = getConnection();
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
