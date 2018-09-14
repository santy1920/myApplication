package com.ideas2it.employeemanagement.service.impl;

import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.dao.ProjectDAO;
import com.ideas2it.employeemanagement.dao.impl.ProjectDAOImpl;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeemanagement.service.ProjectService;

/**
 * <p>
 * This class is used to manipulate and perform business logic operations with 
 * the project details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO = new ProjectDAOImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
  
    /**
     * @{inheritdoc}
     */
    public boolean addProject(Project project) throws EMException {
        return projectDAO.insertProject(project);
    }

    /**
     * @{inheritdoc}
     */
    public List<Project> retrieveProjects() throws EMException {
        return projectDAO.getAllProjects();
    }
    
    /**
     * @{inheritdoc}
     */
    public boolean deleteProject(Project project) throws EMException {
        return projectDAO.deleteProject(project);
    }

    /**
     * @{inheritdoc}
     */
    public boolean updateProject(Project project) throws EMException {
        return projectDAO.updateProject(project);
    }
    
    /**
     * @{inheritdoc}
     */
    public Project searchProject(int projectId) throws EMException {
        return projectDAO.searchProject(projectId);
    }
    
    /**
     * @{inheritdoc}
     */
    public List<Employee> retrieveEmployees() throws EMException {
        return employeeService.retrieveEmployees();
    }

    /**
     * @{inheritdoc}
     */
    public boolean assignEmployeesToProject(Set<Employee> employees,
            Project project) throws EMException {
        project.setEmployees(employees);
        return projectDAO.updateProject(project);
    }
   
    /**
     * @{inheritdoc}
     */
    public boolean removeEmployeesFromProject(Set<Employee> employeesToRemove,
            Project project) throws EMException {
        project.getEmployees().removeAll(employeesToRemove);
        return projectDAO.updateProject(project);
    }

    /**
     * @{inheritdoc}
     */
    public Employee searchEmployee(int employeeId) throws EMException {
        return employeeService.searchEmployee(employeeId);
    }
}
