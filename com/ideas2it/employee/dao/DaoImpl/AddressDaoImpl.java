/**
 * Provides the necessary information to create Address Dao Implementation class
 * To communicate with the sql server database and to convert the address object to table
 */
package com.ideas2it.employee.dao.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ideas2it.employee.dao.AddressDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.util.Datasource;

/**
 * This class handles database information of employee details in persistence logic
 */
public class AddressDaoImpl implements AddressDao {

    private final String INSERT_USERS_SQL = "INSERT INTO address" + " (pincode, city, permanentAddress, temporaryAddress) VALUES " + " (?,?,?,?,?);";

    private final String SELECT_USER_BY_ID = "Select addressID, pincode, city, permanentAddress, temporaryAddress, status from employee where employeeID =?";

    private final String SELECT_ALL_USERS = "select addressID, pincode, city, permanentAddress, temporaryAddress, status from address";

    private final String DELETE_USERS_SQL = "update address SET status=0  where addressID = ?;";

    private final String UPDATE_USERS_SQL = "update address set  phoneNumber = ?, emailID = ?, firstName = ?, lastName =?  where employeeID = ?";

    /**
     * This method is used to create address details in the address table
     * @param address
     * @return address
     */
    @Override
    public Address addAddressId(Address address) {
        System.out.println(INSERT_USERS_SQL);
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getPermanentAddress());
            preparedStatement.setString(3, address.getTemporaryAddress());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return address;
    }

    /**
     * This method is used to update the address details in the address object
     * @param addressId
     * @param city
     * @param pincode
     * @param permanentAddress
     * @param temporaryAddress
     * @return rowCount
     */
    @Override
    public int updateAddressById(int addressId, String city, String pincode, String permanentAddress, String temporaryAddress) {
        int rowCount = 0;
        Datasource datasource = Datasource.getInstance();
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, pincode);
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
     * This method is used to delete address details in the address table
     * @param employeeId
     * @return employeeId
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
}

