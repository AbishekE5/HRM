package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Employee;

public interface EmployeeDao {
    public  void addEmployeebyId(Employee employee);

    public Employee getEmployeebyId(int employeeId);

    public void updateEmployeeById(Employee employee);

    public  void deleteEmployeeById(Integer employeeId);
}
