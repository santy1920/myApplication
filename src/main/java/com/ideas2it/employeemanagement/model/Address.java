package com.ideas2it.employeemanagement.model;

import com.ideas2it.employeemanagement.commons.constants.Constants;

/**
 * <p>
 * This is a Plain-Old-Java-Object Class, which is used to store the address 
 * such as door number, street name, city name, country name, pincode.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Address {
    private Integer id;
    private Integer doorNumber;
    private String street;
    private String city;
    private String country;
    private Integer pinCode;
    private String type;
    private Integer clientId;
    private Integer employeeId;    

    public Address() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
 
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }
}
