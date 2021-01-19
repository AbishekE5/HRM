package com.ideas2it.employee.model;

public class Employee {
    private Integer employeeid;
    private String phoneNumber;
    private String emailID;
    private String firstName;
    private String lastName;
    private boolean status;

    public Employee(Integer employeeid, String phoneNumber, String emailID, String firstName, String lastName) {
        this.employeeid = employeeid;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Employee() {

    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailid() {
        return emailID;
    }

    public void setEmailid(String emailid) {
        this.emailID = emailid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }


    public String toString() {
        return "Employee[EMPLOYEEID= " + employeeid + ", PHONENUMBER= " + phoneNumber + ", EMAILID = " + emailID + ", FIRSTNAME " + firstName + ", LASTNAME " + lastName + "]";
    }
}
