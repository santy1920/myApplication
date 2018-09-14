package com.ideas2it.employeemanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

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
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeemanagement.util.DateUtil;

/**
 * <p>
 * This class is acts as a controller and perform operations 
 * with the employee details.
 * </p>
 *
 * @author Santhosh Kumar
 */
@Controller
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @RequestMapping(value="/employee_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }

    @RequestMapping(value=Constants.CREATE_EMPLOYEE_MAPPING, method=RequestMethod.GET)
    private ModelAndView createEmployee(Model model) {
        Employee employee = new Employee();
        List<Address> listOfAddresses = new ArrayList<Address>();
        Address permanentAddress = new Address();
        listOfAddresses.add(permanentAddress);
        Address temporaryAddress = new Address();        
        listOfAddresses.add(temporaryAddress);
        employee.setListOfAddresses(listOfAddresses);
        return new ModelAndView(Constants.CREATE_EMPLOYEE, Constants.EMPLOYEE, employee);
    }

    @RequestMapping(value=Constants.ADD_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView addEmployee(@ModelAttribute Employee employee) {
        try {
            Set<Address> addresses = new HashSet<Address>();
            addresses.addAll(employee.listOfAddresses);
            employee.setAddresses(addresses);
            if (employeeService.addEmployee(employee)) {
                return new ModelAndView(Constants.EMPLOYEE_MAIN, Constants.
                    EMPLOYEES, employeeService.retrieveEmployees());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.EMPLOYEE_ADDITION_EXCEPTION, employee.getName()));
        }
    }

    /**
     * <p>
     * This method is used to search the particular employee
     * from the employee list and display his details.
     * </p>
     */
    @RequestMapping(value=Constants.SEARCH_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView searchEmployee(@RequestParam(Constants.ID) int id, Model model) {
        try {
            Employee employee = employeeService.searchEmployee(id);
            model.addAttribute(Constants.ID, id);
            if (null != employee) {
                return new ModelAndView(Constants.DISPLAY_EMPLOYEE, Constants.
                    EMPLOYEE, employee);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.EMPLOYEE_SEARCH_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to delete all the details of the employee
     * from the employee list.
     * </p>
     */
    @RequestMapping(value=Constants.DELETE_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView deleteEmployee(@RequestParam(Constants.ID) int id) {
        Employee employee = null;        
        try {
            employee = employeeService.searchEmployee(id); 
            if (employeeService.deleteEmployee(employee)) {
                return new ModelAndView(Constants.EMPLOYEE_MAIN, Constants.
                    EMPLOYEES, employeeService.retrieveEmployees());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.EMPLOYEE_DELETE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to display the employee that are available for
     * employee detail operations.
     * </p>
     */    
    @RequestMapping(value=Constants.DISPLAY_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView displayEmployees() {
        try {
            return new ModelAndView(Constants.EMPLOYEE_MAIN,
                Constants.EMPLOYEES, employeeService.retrieveEmployees());
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, Constants.EMPLOYEE_DISPLAY_EXCEPTION);
        }
    }

    /**
     * <p>
     * This method is used to update the employee details and send it to
     * modify it in the list.
     * </p>
     */ 
    @RequestMapping(value=Constants.UPDATE_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateEmployee(@RequestParam(Constants.ID) int id) {
        try {
            Employee employee = employeeService.searchEmployee(id);
            List<Address> listOfAddresses = new ArrayList<Address>();
            listOfAddresses.addAll(employee.getAddresses());
            employee.setListOfAddresses(listOfAddresses);
            return new ModelAndView(Constants.UPDATE_EMPLOYEE, Constants.
                EMPLOYEE, employee);
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.EMPLOYEE_UPDATE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to modify the employee details and
     * update his details.
     * </p>
     */  
    @RequestMapping(value=Constants.MODIFY_EMPLOYEE_MAPPING, method=RequestMethod.POST)
    private ModelAndView modifyEmployee(@ModelAttribute Employee employee) {
        try {
            Set<Address> addresses = new HashSet<Address>();
            addresses.addAll(employee.listOfAddresses);
            employee.setAddresses(addresses);
            if (employeeService.updateEmployee(employee)) {
                return new ModelAndView(Constants.DISPLAY_EMPLOYEE, Constants.
                    EMPLOYEE, employee);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.EMPLOYEE_UPDATE_EXCEPTION, employee.getId()));
        }
    }
}
