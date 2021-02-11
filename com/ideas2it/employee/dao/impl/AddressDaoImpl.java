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

import com.ideas2it.employee.dao.AddressDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.util.Datasource;

/**
 * This class establishes the database connectivity with the sql server
 * @version 1.1 11 Feb 2021
 * @author Abishek Anand
 */
public class AddressDaoImpl implements AddressDao {

    private final String INSERT_USERS_SQL = "INSERT INTO address1 (city, pincode,  permanent_address, temporary_address , employeeID) VALUES  (?,?,?,?,?);";
    private final String SELECT_USER_BY_ID = "select addressID, city , pincode, permanent_address, temporary_address from address1 where employeeID =?";
    private final String SELECT_ALL_USERS = "Select addressID, city , pincode, permanent_address, temporary_address from address1";
    private final String SELECT_AUTO_ID = "(select max(addressID) from address1)";
    private final String DELETE_USERS_SQL = "update address1 SET status=0  where employeeID = ?;";
    private final String UPDATE_USERS_SQL = "update address1 set  city = ?, pincode = ?, permanent_address =?, temporary_address =?  where employeeID = ?";

    /**
     * {@inheritDoc}
     */
    @Override
    public Address insertAddress(Address address) {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setInt(2, address.getPincode());
            preparedStatement.setString(3, address.getPermanentAddress());
            preparedStatement.setString(4, address.getTemporaryAddress());
            preparedStatement.setInt(5,address.getEmployeeId());
            preparedStatement.executeUpdate();
            preparedStatement= connection.prepareStatement(SELECT_AUTO_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            address.setAddressId(resultSet.getInt("max(addressID)"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return address;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateAddressById(String city, int pincode, String permanentAddress, String temporaryAddress, int employeeId) {
        int rowCount = 0;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, pincode);
            preparedStatement.setString(3, permanentAddress);
            preparedStatement.setString(4, temporaryAddress);
            preparedStatement.setInt(5, employeeId);
            rowCount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteAddressById(int employeeID) {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, employeeID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeID;
    }

    /**
     * {@inheritDoc}
     */
    public Address getAddressById(int employeeId) {
        Address address = null;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                address = new Address();
                address.setEmployeeId(rs.getInt(1));
                address.setCity(rs.getString(2));
                address.setPincode(rs.getInt(3));
                address.setPermanentAddress(rs.getString(4));
                address.setTemporaryAddress(rs.getString(5));
                connection.close();
                return address;
            }
            else {
                return address;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return address;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Address> viewAllAddress(List<Address> address) throws SQLException {
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int employeeId = rs.getInt(1);
                String city = rs.getString(2);
                int pincode = rs.getInt(3);
                String permanentAddress = rs.getString(4);
                String temporaryAddress = rs.getString(5);
                address.add(new Address(city, pincode, permanentAddress, temporaryAddress, employeeId));
            }
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return address;
    }
    }


