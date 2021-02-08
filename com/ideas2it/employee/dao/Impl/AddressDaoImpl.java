/**
 * {@inheritDoc}
 */
package com.ideas2it.employee.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ideas2it.employee.dao.AddressDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.util.Datasource;

/**
 * {@inheritDoc}
 */
public class AddressDaoImpl implements AddressDao {

    private final String INSERT_USERS_SQL = "INSERT INTO address1 (city, permanent_address, temporary_address ,pincode) VALUES  (?,?,?,?);";
    private final String SELECT_USER_BY_ID = "Select addressID, city, permanent_address, temporary_address , pincode from address1 where addressId =?";
    private final String SELECT_AUTO_ID = "(select max(addressID) from address1)";
    private final String DELETE_USERS_SQL = "update address1 SET status=0  where addressID = ?;";
    private final String UPDATE_USERS_SQL = "update address1 set  city = ?, permanent_address = ?, pincode = ?, temporary_address =?  where addressId = ?";

    /**
     * {@inheritDoc}
     */
    @Override
    public Address insertAddress(Address address) {
        System.out.println(INSERT_USERS_SQL);
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getPermanentAddress());
            preparedStatement.setString(3, address.getTemporaryAddress());
            preparedStatement.setInt(4, address.getPincode());
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
    public int updateAddressById(int addressId, String city, int pincode, String permanentAddress, String temporaryAddress) {
        int rowCount = 0;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, pincode);
            preparedStatement.setString(3, permanentAddress);
            preparedStatement.setString(4, temporaryAddress);
            preparedStatement.setInt(5, addressId);
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
    public int deleteAddressById(int employeeId) {
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
     * {@inheritDoc}
     */

    public Address getAddressById(int addressId) {
        Address address = null;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, addressId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                address = new Address();
                address.setAddressId(rs.getInt(1));
                address.setCity(rs.getString(2));
                address.setPermanentAddress(rs.getString(3));
                address.setPincode(rs.getInt(4));
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
}

