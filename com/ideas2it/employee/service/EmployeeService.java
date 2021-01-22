package com.ideas2it.employee.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ideas2it.employee.dao.EmployeeDaoImpl;
import com.ideas2it.employee.model.Employee;

public class EmployeeService {
    EmployeeDaoImpl dao = new EmployeeDaoImpl();

    /**
     * This method is used to create the employee details.
     *
     * @param employeeid  This is the first parameter to create Employee
     * @param phoneNumber This is the second parameter to create Employee
     * @param emailID     This is the third parameter to createEmployee
     * @param firstName   This is the fourth parameter to createEmployee
     * @param lastName    This is the fifth parameter to createEmployee
     * @return employeeid, phoneNumber, emailID, firstName, lastName
     */

    public Employee employeeStore(Integer employeeid, String phoneNumber, String emailID, String firstName, String lastName) {
        Employee employee = new Employee(employeeid, phoneNumber, emailID, firstName, lastName);
        return dao.addEmployeeDetails(employee);
    }
    /**
     * This method is used to delete the employee details.
     * @param delete
     * @return delete
     */
    public Employee deleteEmployee(Integer delete) {
        return dao.deleteEmployee(delete);

    }

    /**
     * This method is used to retrive the employee details.
     * @param
     * @return recievedEmployee
     */

    public Employee getEmployeeById(int id){
        return dao.getEmployeeById(id);

    }
    /**
     * This method is used to update the employee details.
     */

    public int updateEmployee(Integer update, String phoneNumber, String emailID, String firstName, String lastName) {

        return dao.updateEmployee(update,phoneNumber,emailID,firstName,lastName);

    }
    /**
     * This method is used to validate phone number
     * @param phoneNumber
     * @return true, false
     */
    public boolean phoneNumber (String phoneNumber){
        String number = "\\d{10}";

        //Creating a pattern object
        Pattern pattern = Pattern.compile(number);
        //Creating a Matcher object
        Matcher matcher = pattern.matcher(phoneNumber);
        //Verifying whether given phone number is valid
        if (matcher.matches()) {
            return true;

        } else {
            return false;

        }


    }
}
