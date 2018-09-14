package com.ideas2it.employeemanagement.model;

import com.ideas2it.employeemanagement.commons.constants.Constants;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of users.
 * </p>
 *
 * @author Santhosh Kumar
 */ 
public class User {
    private int id;
    private String emailId;
    private String password;
    private Boolean active;

    public User() {
    }
     
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
