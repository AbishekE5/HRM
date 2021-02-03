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
    private String pincode;
    private String permanentAddress;
    private String temporaryAddress;

    /**
     * Parameterized constructor of Address object
     * @param addressId
     * @param city
     * @param pincode
     * @param permanentAddress
     * @param temporaryAddress
     */
    public Address(int addressId, String city, String pincode, String permanentAddress, String temporaryAddress) {
        this.addressId = addressId;
        this.city = city;
        this.pincode = pincode;
        this.permanentAddress = permanentAddress;
        this.temporaryAddress = temporaryAddress;
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
    public void setAddressId(Integer addressId) {
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
    public String getPincode() {
        return pincode;
    }

    /**
     * This method sets the pincode object
     */
    public void setPincode(String pincode) {
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
     * This method appends the entire object to a list
     */
    public String toString() {
        return "ADDRESS[ ID = " + addressId + ", CITY= " + city + ", PINCODE= " + pincode + " PERMANENT ADDRESS = " + permanentAddress + " TEMPORARY ADDRESS" + temporaryAddress + "]";
    }

}
