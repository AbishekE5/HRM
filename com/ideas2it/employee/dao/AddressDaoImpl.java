package com.ideas2it.employee.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ideas2it.employee.model.Address;
import com.ideas2it.util.Datasource;

public class AddressDaoImpl implements AddressDao {

    private static final String INSERT_USERS_SQL = "INSERT INTO address" + " (pincode,city,permanentAddress,temporaryAddress) VALUES " + " (?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "Select pincode,city,permanentAddress,temporaryAddress from address where employeeID =?";

    private static final String SELECT_ALL_USERS = "select * from address";

    private static final String DELETE_USERS_SQL = "update address SET status=0  where employeeID = ?;";

    private static final String UPDATE_USERS_SQL = "update address set pincode =?, city = ?, permanentAddress = ?, temporaryAddress = ?  where employeeID = ?";

    /**
     * This method is used to create the address details.
     * @param address
     * @return address
     */
    @Override
    public Address createAddress(Address address) throws SQLException {
        System.out.println(INSERT_USERS_SQL);

        try {

            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getPermanentAddress());
            preparedStatement.setString(3, address.getTemporaryAddress());
            preparedStatement.setString(4, address.getPincode());
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return address;
    }

    /**
     * This method is used to delete the address details.
     * @param id
     * @return employee
     */

    @Override
    public int deleteAddress(int id) {
        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    /**
     * This method is used to update the address details.
     * @param  city,pincode,permanentAddress,temporaryAddress
     * @return rowCount
     */

    public int updateAddress(String city, String pincode, String permanentAddress,String temporaryAddress) {
        int rowCount = 0;
        try {
            Datasource datasource = new Datasource();
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, pincode);
            preparedStatement.setString(3, permanentAddress);
            preparedStatement.setString(4, temporaryAddress);
            //preparedStatement.setInt(5);
            rowCount = preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rowCount;
    }
}
