package com.ideas2it.employeemanagement.dao;

import java.util.List;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on employee data such as add, update, remove and search.
 * on employee details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface EmployeeDAO {

    /**
     * <p>
     * This method is used to add the employee
     * details to the list.
     * </p>
     *
     * @return employees returns true if the details of employee
     * is added to the list.
     */
    public boolean insertEmployee(Employee employee) throws EMException;

    /**
     * <p>
     * This method is used to find the employee id
     * and delete his details from the list.
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
     * id and return his details in the list.
     * </p> 
     *
     * @param employeeId Id of the employee.
     *
     * @return Employee details of the employee.
     */
    public Employee searchEmployee(int employeeId) throws EMException;
    
    /**
     * <p>
     * This method is used to search the particular employee
     * modify and update his details in the list.
     * </p> 
     *
     * @param employee employee details.
     *
     * @return Employee details of the employee.
     */
    public boolean updateEmployee(Employee employee) throws EMException;
    
    /**
     * <p>
     * This method is used to return the list of employee
     * details.
     * </p>
     *
     * @return employeeDetails returns employeeDetails.
     */ 
    public List<Employee> getAllEmployees() throws EMException; 
}
