package com.ideas2it.employeemanagement.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.model.Employee;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of projects.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Project {
    private int id;
    private String name;
    private String client;
    private int clientId;
    private boolean active; 
    private Set<Employee> employees = new HashSet<Employee>();

    public Project() {
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
   
    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public Set<Employee> getEmployees() {
       return employees;
    }
 
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
  
    /**
     * <p>
     * This is used to check whether the projectid equals or not
     * </p>
     *
     * @param project Project details
     *
     * @return boolean either true or false
     */
    public boolean equals(Project project) {
         return (project.getId() == this.id);
    }
} 
