package com.ideas2it.employee.dao;
import com.ideas2it.employee.model.Address;
import java.sql.SQLException;

public interface AddressDao {
    Address createAddress(Address address) throws SQLException;

    int deleteAddress(int id);
}
