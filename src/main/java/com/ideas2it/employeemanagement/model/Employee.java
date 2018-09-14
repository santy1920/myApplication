package com.ideas2it.employeemanagement.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.util.DateUtil;

/**
 * <p>
 * This class is a Plain-Old-Java-Object Class used to implement a
 * structured class whose objects can be used to store and implement data
 * storage and retrieval on data of employees.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class Employee {
    private int id;
    private String name;
    private String role;
    private int salary;
    private Date dob;
    private String emailId;
    private boolean active; 
    private Set<Project> projects = new HashSet<Project>();
    private Set<Address> addresses = new HashSet<Address>();
    public List<Address> listOfAddresses = new ArrayList<Address>();
 
    public Employee() {
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
  
    public void setRole(String role) {
        this.role = role;
    }
     
    public String getRole() {
        return role;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
     
    public int getSalary() {
        return salary;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public Date getDob() {
        return dob;
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
        return this.active;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }
 
    public void setListOfAddresses(List<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    public List<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    /**
     * <p>
     * Used to check whether the id equals or not
     * </p>
     *
     * @param employee Employee details
     *
     * @return boolean either true or false
     */
    public boolean equals(Employee employee) {
         return (employee.getId() == this.id);
    }
 
    /**
     * <p>
     * Used to calculate age for given dateofbirth
     * </p>
     *
     * @param dob - input date of birth
     *
     * @return difference in the dates.
     */
    public int getAge(Date dob) {
        return DateUtil.getDateDifference(dob);
    }
}

