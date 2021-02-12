/**
 * Provides the necessary information to create Address model class
 * To create objects and to communicate with the Dao classes where it is stored
 */
package com.ideas2it.employee.model;

/**
 * This class creates the address objects
 */
public class Address {

    private int addressId;
    private String city;
    private int pincode;
    private String permanentAddress;
    private String temporaryAddress;
    private int employeeId;

    /**
     * Parameterized constructor of Address object
     * @param city
     * @param pincode
     * @param permanentAddress
     * @param temporaryAddress
     */
    public Address(String city, int pincode, String permanentAddress, String temporaryAddress, int employeeId) {

        this.city = city;
        this.pincode = pincode;
        this.permanentAddress = permanentAddress;
        this.temporaryAddress = temporaryAddress;
        this.employeeId = employeeId;
    }

    /**
     * Default constructor
     */
    public Address() {

    }
    /**
     * This method gets the AddressId object
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * This method sets the AddressId object
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * This method gets the city object
     */
    public String getCity() {
        return city;
    }

    /**
     * This method sets the city object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method gets the pincode object
     */
    public int getPincode() {
        return pincode;
    }

    /**
     * This method sets the pincode object
     */
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    /**
     * This method gets the permanent address object
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * This method sets the permanent address object
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * This method gets the temporary address object
     */
    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    /**
     * This method sets the temporary address object
     */
    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    /**
     * This method is used to get the employee Id
     * @return employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * This method is used to set the employee Id
     * @return employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * This method appends the entire object to a list
     */
    public String toString() {
        return "ADDRESS[ CITY= " + city + ", PINCODE= " + pincode + " PERMANENT ADDRESS = " + permanentAddress + " TEMPORARY ADDRESS = " + temporaryAddress +"]";
    }

}
