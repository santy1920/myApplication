package com.ideas2it.employeemanagement.service;

import java.util.List;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes for 
 * to implement data manipulation operations and business logic 
 * on Employee Data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface EmployeeService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of employee addition to the database.
     * </p>
     *
     * @return employeeDetails returns true if the details of employee
     * is added.
     */ 
    public boolean addEmployee(Employee employee) throws EMException;
 
    /**
     * <p>
     * This method is used to find the employee id
     * and delete his details from the database.
     * </p>
     *
     * @param employee employee details.
     *
     * @return boolean either true or false.
     */
    public boolean deleteEmployee(Employee employee) throws EMException;

    /**
     * <p>
     * This method is used to search the particular employee
     * detail in the list.
     * </p> 
     *
     * @param employeeId Id of the employee.
     *
     * @return employee details of the employee.
     */
    public Employee searchEmployee(int employeeId) throws EMException;

    /**
     * <p>
     * This method is used to return the employee
     * details from the database.
     * </p>
     *
     * @return employees returns employeeDetails.
     */ 
    public List<Employee> retrieveEmployees() throws EMException;
    
    /**
     * <p>
     * This method is used to update the employee
     * details in the database.
     * </p>
     *
     * @return boolean either true or false.
     */ 
    public boolean updateEmployee(Employee employee) throws EMException;

}   
