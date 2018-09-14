package com.ideas2it.employeemanagement.service.impl;

import java.util.List;

import com.ideas2it.employeemanagement.dao.EmployeeDAO;
import com.ideas2it.employeemanagement.dao.impl.EmployeeDAOImpl;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.service.ProjectService;

/**
 * <p>
 * This is a Service-Layer class, which is used for the purpose
 * of providing Business Logic to operations on employee data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    /**
     * @{inheritdoc}
     */
    public boolean addEmployee(Employee employee) throws EMException {
        return employeeDAO.insertEmployee(employee);
    }
  
    /**
     *  @{inheritDoc}
     */
    public boolean deleteEmployee(Employee employee) throws EMException {
        return employeeDAO.deleteEmployee(employee);
    }    
 
    /**
     * @{inheritdoc}
     */
    public Employee searchEmployee(int employeeId) throws EMException {
        return employeeDAO.searchEmployee(employeeId);
    }

    /**
     * @{inheritdoc}
     */ 
    public List<Employee> retrieveEmployees() throws EMException {
        return employeeDAO.getAllEmployees();
    }
  
    /**
     * @{inheritdoc}
     */ 
    public boolean updateEmployee(Employee employee) throws EMException {
        return employeeDAO.updateEmployee(employee);
    }
}
        
