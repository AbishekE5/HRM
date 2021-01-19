package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Employee;

import java.sql.SQLException;

public interface EmployeeDao {
    Employee addEmployeeDetails(Employee employee) throws SQLException;



    Employee deleteEmployee(int id);
}
