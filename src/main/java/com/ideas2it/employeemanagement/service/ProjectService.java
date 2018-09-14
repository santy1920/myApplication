package com.ideas2it.employeemanagement.service;

import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes for 
 * to implement data manipulation operations and business logic on project data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface ProjectService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of project addition to the database.
     * </p>
     *
     * @return projectDetails returns true if the details of project
     * is added.
     */ 
    public boolean addProject(Project project) throws EMException;

    /**
     * <p>
     * This method is used to return the list of project
     * details from the database.
     * </p>
     *
     * @return projectDetails returns projectDetails.
     */
    public List<Project> retrieveProjects() throws EMException;
    
    /**
     * <p>
     * This method is used to delete the project 
     * details from the list.
     * </p>
     *
     * @param projectId Id of the employee.
     *
     * @return boolean either true or false.
     */
    public boolean deleteProject(Project project) throws EMException;
     
    /**
     * <p>
     * This method is used to update the project
     * details in the database.
     * </p>
     *
     * @return true if project is updated.
     */ 
    public boolean updateProject(Project project) throws EMException;

    /**
     * <p>
     * This method is used to search the project Id
     * and return its details from the database.
     * </p>
     *
     * @param projectId Id of the employee.
     *
     * @return Project project details.
     */
    public Project searchProject(int projectId) throws EMException;
  
    /**
     * <p>
     * This method is used to search the employee Id
     * and return his/her details from the database.
     * </p>
     *
     * @param employeeId Id of the employee.
     *
     * @return Employee employee details.
     */
    public Employee searchEmployee(int employeeId) throws EMException;

    /**
     * <p>
     * This method is used to retrieve all the employees
     * and return its details from the database.
     * </p>
     *
     * @return List<Employee> employee details.
     */
    public List<Employee> retrieveEmployees() throws EMException;

    /**
     * <p>
     * This method is used to remove the employees present in a particular
     * project from the database.
     * </p>
     *
     * @param employees List<Employee>
     * @param project Project
     *
     * @return either true or false
     */
    public boolean removeEmployeesFromProject(Set<Employee> employeesToRemove,
        Project project) throws EMException;

    /**
     * <p>
     * This method is used to assign the employees to the particular project
     * and update its details in the database.
     * </p>
     *
     * @param employees List<Employee>
     * @param project Project
     *
     * @return either true or false
     */  
    public boolean assignEmployeesToProject(Set<Employee> employees,
        Project project) throws EMException;

}
