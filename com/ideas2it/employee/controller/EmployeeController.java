package com.ideas2it.employee.controller;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;

public class EmployeeController {
    EmployeeService service = new EmployeeService();

    /**
     * This method is used to send the user input to create employee details.
     *
     * @param employeeid  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employeeid, phoneNumber, emailID, firstName, lastName
     */
    public Employee createEmployee(Integer employeeid, String phoneNumber, String emailID, String firstName, String lastName) {

        return service.employeeStore(employeeid, phoneNumber, emailID, firstName, lastName);

    }

    /**
     * This method is used to send the user input to delete employee details.
     *
     * @param delete This is the  parameter to delete Employee
     * @return delete
     */
    public Employee deleteEmployee(Integer delete) {

        return service.deleteEmployee(delete);
    }

    /**
     * This method is used to validate phone number entered by user.
     * @param phoneNumber
     * @return phoneNumber
     */
    public boolean phoneNumber (String phoneNumber){
        return service.phoneNumber(phoneNumber);
    }

    /**
     * This method is used retrive employee details.
     */
    public Employee getEmployeeById(int id){
        return service.getEmployeeById(id);

    }

    /**
     * This method is used to update employee entered by user.

     */
    public int updateEmployee(Integer update, String phoneNumber, String emailID, String firstName, String lastName) {
        return service.updateEmployee(update,phoneNumber,emailID,firstName,lastName);
    }
}
