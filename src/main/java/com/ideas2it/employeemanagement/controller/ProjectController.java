package com.ideas2it.employeemanagement.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.logger.Logger;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.impl.ProjectServiceImpl;
import com.ideas2it.employeemanagement.service.ProjectService;

/**
 * <p>
 * This class acts as a controller and perform operations with 
 * the project details.
 * </p>
 *
 * @author Santhosh Kumar
 */
@Controller
public class ProjectController {
    private ProjectService projectService = new ProjectServiceImpl();

    @RequestMapping(value="/project_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }
 
    /**
     * <p>
     * This method is used to add a new project after getting details
     * from the user, store and add that object to the projectlist.
     * </p>
     */
    @RequestMapping(value=Constants.CREATE_PROJECT_MAPPING, method=RequestMethod.GET)
    private ModelAndView createEmployee(Model model) {
        Project project = new Project();
        return new ModelAndView(Constants.CREATE_PROJECT, Constants.PROJECT, project);
    }

    @RequestMapping(value=Constants.ADD_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView addProject(@ModelAttribute Project project) {
        try {
            if (projectService.addProject(project)) {
                return new ModelAndView(Constants.PROJECT_MAIN, Constants.
                    PROJECTS, projectService.retrieveProjects());
            } else {
                return new ModelAndView(Constants.ERROR);
            } 
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.PROJECT_ADDITION_EXCEPTION, project.getName()));
        }
    }

    /**
     * <p>
     * This method is used to update the details of a particular project and 
     * send it to modify in the project list.
     * </p>
     */
    @RequestMapping(value=Constants.UPDATE_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateProject(@RequestParam(Constants.ID) int id) {
        try {
            return new ModelAndView(Constants.UPDATE_PROJECT, Constants.
                PROJECT, projectService.searchProject(id));
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.PROJECT_UPDATE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to modify the project details and
     * update its details.
     * </p>
     */
    @RequestMapping(value=Constants.MODIFY_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView modifyProject(@ModelAttribute Project project) {
        try {
            if (projectService.updateProject(project)) {
                return new ModelAndView(Constants.DISPLAY_PROJECT, Constants.
                    PROJECT, project);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.PROJECT_UPDATE_EXCEPTION, project.getId()));
        }
    }

    /**
     * <p>
     * This method is used to display the projects that are being done
     * by the employees.
     * </p>
     */
    @RequestMapping(value=Constants.DISPLAY_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView displayProjects() {
        try {
            return new ModelAndView(Constants.PROJECT_MAIN,
                Constants.PROJECTS, projectService.retrieveProjects());
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, Constants.PROJECT_DISPLAY_EXCEPTION);
        }
    }

    /**
     * <p>
     * This method is used to search the particular
     * project from the project list.
     * </p>
     */
    @RequestMapping(value=Constants.SEARCH_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView searchProject(@RequestParam(Constants.ID) int id, Model model) {
        try {
            Project project  = projectService.searchProject(id);
            model.addAttribute(Constants.ID, id);
            if (null != project) {
                return new ModelAndView(Constants.DISPLAY_PROJECT, Constants.
                    PROJECT, project);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.PROJECT_SEARCH_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to delete all the project details from the 
     * project list.
     * </p>
     */
    @RequestMapping(value=Constants.DELETE_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView deleteProject(@RequestParam(Constants.ID) int id) {
        Project project = null;        
        try {
            project = projectService.searchProject(id); 
            if (projectService.deleteProject(project)) {
                return new ModelAndView(Constants.PROJECT_MAIN, Constants.
                    PROJECTS, projectService.retrieveProjects());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.PROJECT_DELETE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to select the particular employees from the list of 
     * employees and send them to assign to a project.
     * </p>
     */
    @RequestMapping(value=Constants.SELECT_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView selectEmployeesToAssign(@RequestParam(Constants.ID) int id) {
        try { 
        Project project = projectService.searchProject(id);                    
        List<Employee> employees = projectService.retrieveEmployees();
        Set<Employee> employeesToRemove = new HashSet<Employee>();
        for (Employee employee : employees) {
            for (Employee employeeToRemove : project.getEmployees()) {
                if (employee.getId() == employeeToRemove.getId()) {
                    employeesToRemove.add(employee);
                }
            }
        }
        employees.removeAll(employeesToRemove);
        ModelAndView modelAndView = new ModelAndView(Constants.ASSIGN_EMPLOYEE);
        modelAndView.addObject(Constants.EMPLOYEES, employees);
        modelAndView.addObject(Constants.PROJECT, project);        
        return modelAndView;       
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.PROJECT_ASSIGN_EMPLOYEE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to assign the selected employees to the project and 
     * update the project list.
     * </p>
     */
    @RequestMapping(value=Constants.ASSIGN_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView assignEmployees(@RequestParam(Constants.ID) int id,
            @RequestParam(Constants.ID_OF_EMPLOYEES) Integer[] idOfEmployees) {
        try {
            Project project = projectService.searchProject(id);
            List<Employee> employees = projectService.retrieveEmployees(); 
            Set<Employee> employeesToAssign = new HashSet<Employee>();
            employeesToAssign.addAll(project.getEmployees());
            if (null != idOfEmployees) {
                for (Integer idOfEmployee : idOfEmployees) {
                    for (Employee employee : employees) {
                        if (employee.getId() == idOfEmployee) {
                            employeesToAssign.add(employee);
                            break;
                        }
                    }
                } 
                projectService.assignEmployeesToProject(employeesToAssign, project);
                return new ModelAndView(Constants.DISPLAY_PROJECT, Constants.
                    PROJECT, project);
            } else {
                return new ModelAndView(Constants.DISPLAY_PROJECT, Constants.
                    PROJECT, project);
            }          
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.PROJECT_ASSIGN_EMPLOYEE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to remove selected assigned employees from a project 
     * and update the project list.
     * </p>
     */
    @RequestMapping(value=Constants.REMOVE_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView removeEmployeeFromProject(@RequestParam(Constants.ID) int id,
            @RequestParam(Constants.ID_OF_EMPLOYEES) Integer[] idOfEmployees) {
        Employee employeeToRemove = null;
        try {
            Project project = projectService.searchProject(id);
            if (null != idOfEmployees) {
                for (Integer idOfEmployee : idOfEmployees) {
                    for (Employee employee : project.getEmployees()) {
                        if (employee.getId() == idOfEmployee) {                    
                            employeeToRemove = employee;
                            break;
                        }
                    }    
                    project.getEmployees().remove(employeeToRemove);
                }
                projectService.updateProject(project);
                return new ModelAndView(Constants.DISPLAY_PROJECT, Constants.
                    PROJECT, project);
            } else {
                return new ModelAndView(Constants.DISPLAY_PROJECT, Constants.
                    PROJECT, project);
            }         
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.PROJECT_REMOVE_EMPLOYEE_EXCEPTION, id));
        }
    }
}
