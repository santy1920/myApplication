package com.ideas2it.employeemanagement.dao;

import java.util.List;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Project;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on project data such as add, update, remove and search.
 * on project details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface ProjectDAO { 
    
    /**
     * <p>
     * This method is used to add the project
     * details to the list.
     * </p>
     *
     * @return boolean returns true if the details of project
     * is added to the list.
     */
    public boolean insertProject(Project project) throws EMException;

    /**
     * <p>
     * This method is used to return the project
     * details from the list.
     * </p>
     *
     * @return Project returns projectDetails.
     */ 
    public List<Project> getAllProjects() throws EMException;

    /**
     * <p>
     * This method is used to find the project Id
     * and delete its details from the list.
     * </p>
     *
     * @param projectId Id of the project.
     *
     * @return boolean either true or false.
     */
    public boolean deleteProject(Project project) throws EMException;
    
    /**
     * <p>
     * This method is used to update the project
     * details in the list.
     * </p>
     *
     * @return true if project is updated.
     */ 
    public boolean updateProject(Project project) throws EMException;

    /**
     * <p>
     * This method is used to search the particular project
     * detail in the list.
     * </p> 
     *
     * @param projectId int contains Id of the project.
     *
     * @return Project details of the project.
     */
    public Project searchProject(int projectId) throws EMException;

}
