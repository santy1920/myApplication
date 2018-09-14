package com.ideas2it.employeemanagement.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Project;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of projects.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Client {
    private int id;
    private String name;
    private String companyName;
    private String emailId;
    private boolean active; 
    private Set<Project> projects = new HashSet<Project>();
    private Set<Address> addresses = new HashSet<Address>();
    public List<Address> listOfAddresses = new ArrayList<Address>();

    public Client() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
   
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getEmailId() {
        return emailId;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    
    public Set<Project> getProjects() {
        return projects;
    }  

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setListOfAddresses(List<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    public List<Address> getListOfAddresses() {
        return listOfAddresses;
    }
}
