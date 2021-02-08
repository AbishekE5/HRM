/**
 * Provides the necessary information to create Employee model class
 * To create objects and to communicate with the Dao classes where it is stored
 */
package com.ideas2it.employee.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the employee objects
 */
public class Employee {

    private List<Address> addressList = new ArrayList<Address>();
    private int employeeId;
    private String phoneNumber;
    private String emailId;
    private String firstName;
    private String lastName;
    private boolean status;
    private boolean employeeFlag;

    public boolean isEmployeeFlag() {
        return employeeFlag;
    }

    public void setEmployeeFlag(boolean employeeFlag) {
        this.employeeFlag = employeeFlag;
    }

    /**
     * Parameterized constructor of Employee object
     * @param phoneNumber
     * @param emailId
     * @param firstName
     * @param lastName
     */
    public Employee(String emailId, String firstName, String lastName, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Default constructor
     */
    public Employee() {
    }

    /**
     * Parameterized constructor of Employee object
     * @param employeeId
     * @param emailId
     * @param firstName
     * @param lastName
     * @param phoneNumber
     */
    public Employee(int employeeId, String emailId, String firstName, String lastName, String phoneNumber) {
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * This method is used to get boolean object
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * This method is used to set boolean object
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * This method is used to get employeeId object
     */
    public int getEmployeeid() {
        return this.employeeId;
    }


    /**
     * This method is used to set employeeId object
     */
    public void setEmployeeid(int employeeid) {
        this.employeeId = employeeid;
    }

    /**
     * This method is used to get phone number object
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method is used to set employeeId object
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method is used to get email ID object
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * This method is used to set email ID object
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * This method is used to get first name object
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method is used to set first name object
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method is used to get last name object
     */
    public String getLastname() {
        return lastName;
    }

    /**
     * This method is used to set last name object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method is used to set address list object
     */
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    /**
     * This method is used to get address list object
     */
    public List<Address> getAddressList() {
        return addressList;
    }

    /**
     * This method is used to append all the employee objects in a list
     */
    public String toString() {
        return "Employee[EMPLOYEEID= " + employeeId + ",   EMAILID = " + emailId + ", FIRSTNAME " + firstName + ", LASTNAME " + lastName + ", PHONENUMBER " + phoneNumber +"]";
    }
}
