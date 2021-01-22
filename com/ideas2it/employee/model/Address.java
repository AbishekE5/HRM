package com.ideas2it.employee.model;

public class Address {
    private String city;
    private String pincode;
    private String permanentAddress;
    private String temporaryAddress;

    public Address(String city, String pincode, String permanentAddress, String temporaryAddress) {
        this.city = city;
        this.pincode = pincode;
        this.permanentAddress = permanentAddress;
        this.temporaryAddress = temporaryAddress;
    }

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public String toString() {
        return "ADDRESS[CITY= " + city + ", PINCODE= " + pincode + " PERMANENT ADDRESS = " + permanentAddress + " TEMPORARY ADDRESS" + temporaryAddress +  "]";
    }
}
