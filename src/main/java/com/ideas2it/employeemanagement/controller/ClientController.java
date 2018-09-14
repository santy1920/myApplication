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
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Client;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.impl.ClientServiceImpl;
import com.ideas2it.employeemanagement.service.ClientService;
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
public class ClientController {
    private ClientService clientService = new ClientServiceImpl();
    
    @RequestMapping(value="/client_index", method=RequestMethod.GET)
    private ModelAndView back() {
         return new ModelAndView("index");
    }
   
    @RequestMapping(value=Constants.CREATE_CLIENT_MAPPING, method=RequestMethod.GET)
    private ModelAndView createClient(Model model) {
        Client client = new Client();
        Address address = new Address();
        List<Address> listOfAddresses = new ArrayList<Address>();
        listOfAddresses.add(address);
        client.setListOfAddresses(listOfAddresses);
        return new ModelAndView(Constants.CREATE_CLIENT, Constants.CLIENT, client);
    }

    /**
     * <p>
     * This method is used to add a new client after obtaining details
     * from the user, store and add that object to the client list.
     * </p>
     */
    @RequestMapping(value=Constants.ADD_CLIENT_MAPPING, method=RequestMethod.POST)
    private ModelAndView addClient(@ModelAttribute Client client) {
        try {
            Set<Address> addresses = new HashSet<Address>();
            addresses.addAll(client.listOfAddresses);
            client.setAddresses(addresses);
            if (clientService.addClient(client)) {
                return new ModelAndView(Constants.CLIENT_MAIN, Constants.
                    CLIENTS, clientService.retrieveClients());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.CLIENT_ADDITION_EXCEPTION, client.getName()));
        }
    }
  
    /**
     * <p>
     * This method is used to update the particular client details and 
     * send them to modify it in the list.
     * </p>
     */
    @RequestMapping(value=Constants.UPDATE_CLIENT_MAPPING, method=RequestMethod.POST)
    private ModelAndView updateClient(@RequestParam(Constants.ID) int id) {
        try {
            Client client = clientService.searchClient(id);
            List<Address> listOfAddresses = new ArrayList<Address>();
            listOfAddresses.addAll(client.getAddresses());
            client.setListOfAddresses(listOfAddresses);
            return new ModelAndView(Constants.UPDATE_CLIENT, Constants.
                CLIENT, client);
        } catch (EMException e) {
           return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.CLIENT_UPDATE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to modify the client details and
     * update its details.
     * </p>
     */
    @RequestMapping(value=Constants.MODIFY_CLIENT_MAPPING, method=RequestMethod.POST)
    private ModelAndView modifyClient(@ModelAttribute Client client) {
        try {
            Set<Address> addresses = new HashSet<Address>();
            addresses.addAll(client.listOfAddresses);
            client.setAddresses(addresses);
            if (clientService.updateClient(client)) {
                return new ModelAndView(Constants.DISPLAY_CLIENT, Constants.
                    CLIENT, client);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.CLIENT_UPDATE_EXCEPTION, client.getId()));
        }
    }

    /**
     * <p>
     * This method is used to search the particular client
     * from the client list and display its details.
     * </p>
     */ 
    @RequestMapping(value=Constants.SEARCH_CLIENT_MAPPING, method=RequestMethod.POST)
    private ModelAndView searchClient(@RequestParam(Constants.ID) int id, Model model) {
        try {
            Client client  = clientService.searchClient(id);
            model.addAttribute(Constants.ID, id);
            if (null != client) {
                return new ModelAndView(Constants.DISPLAY_CLIENT, Constants.
                    CLIENT, client);
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.CLIENT_SEARCH_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to display all the details of the client that are 
     * available in the list.
     * </p>
     */
    @RequestMapping(value=Constants.DISPLAY_CLIENT_MAPPING, method=RequestMethod.POST)
    private ModelAndView displayClients() {
        try {
            return new ModelAndView(Constants.CLIENT_MAIN,
                Constants.CLIENTS, clientService.retrieveClients());
        } catch (EMException e) {
            e.printStackTrace();
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, Constants.CLIENT_DISPLAY_EXCEPTION);
        }
    }

    /**
     * <p>
     * This method is used to delete the particular client
     * from the clients list.
     * </p>
     */
    @RequestMapping(value=Constants.DELETE_CLIENT_MAPPING, method=RequestMethod.POST)
    private ModelAndView deleteClient(@RequestParam(Constants.ID) int id) {
        Client client = null;        
        try {
            client = clientService.searchClient(id); 
            if (clientService.deleteClient(client)) {
                return new ModelAndView(Constants.CLIENT_MAIN, Constants.
                    CLIENTS, clientService.retrieveClients());
            } else {
                return new ModelAndView(Constants.ERROR);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.
                ERROR_MESSAGE, String.format(Constants.CLIENT_DELETE_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to select the particular projects from the list of 
     * projects and send them to assign to a client.
     * </p>
     */
    @RequestMapping(value=Constants.SELECT_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView selectProjectsToAssign(@RequestParam(Constants.ID) int id) {
        try {
        Client client = clientService.searchClient(id);                    
        List<Project> projects = clientService.retrieveProjects();
        List<Project> projectsToRemove = new ArrayList<Project>();
        for (Project project : projects) {
            for (Project projectToRemove : client.getProjects()) {
                if (project.getId() == projectToRemove.getId()) {
                    projectsToRemove.add(project);
                }
            }
        }
        projects.removeAll(projectsToRemove);
        ModelAndView modelAndView = new ModelAndView(Constants.ASSIGN_PROJECT);
        modelAndView.addObject(Constants.PROJECTS, projects);
        modelAndView.addObject(Constants.CLIENT, client);        
        return modelAndView;       
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.CLIENT_ASSIGN_PROJECT_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to assign projects to a particular client and
     * update its details.
     * </p>
     *
     * @param client Client
     */    
    @RequestMapping(value=Constants.ASSIGN_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView assignProjects(@RequestParam(Constants.ID) int id,
            @RequestParam(Constants.ID_OF_PROJECTS) String[] idOfProjects) {
        try {
            Client client = clientService.searchClient(id);
            String checkboxes[] = idOfProjects;
            List<Project> projects = clientService.retrieveProjects(); 
            Set<Project> projectsToAssign = new HashSet<Project>();
            projectsToAssign.addAll(client.getProjects());
            if (null != checkboxes) {
                for (String idOfProject : checkboxes) {
                    for (Project project : projects) {
                        if (project.getId() == Integer.parseInt(idOfProject)) {
                            projectsToAssign.add(project);
                            break;
                        }
                    }
                }
            } else {
                displayClients();
            }            
            clientService.assignProjectsToClient(projectsToAssign, client);
            return new ModelAndView(Constants.DISPLAY_CLIENT, Constants.
                CLIENT, client);
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.CLIENT_ASSIGN_PROJECT_EXCEPTION, id));
        }
    }

    /**
     * <p>
     * This method is used to remove projects of a particular client and
     * update its details.
     * </p>
     *
     * @param client Client
     */    
    @RequestMapping(value=Constants.REMOVE_PROJECT_MAPPING, method=RequestMethod.POST)
    private ModelAndView removeProjectFromClient(@RequestParam(Constants.ID) int id,
            @RequestParam(Constants.ID_OF_PROJECTS) String[] idOfProjects) {
        Project projectToRemove = null;
        try {
            Client client = clientService.searchClient(id);
            String checkboxes[] = idOfProjects;
            if (null != checkboxes) {
                for (String idOfProject : checkboxes) {
                    for (Project project : client.getProjects()) {
                        if (project.getId() == Integer.parseInt(idOfProject)) {                    
                            projectToRemove = project;
                            break;
                        }
                    }    
                    client.getProjects().remove(projectToRemove);
                }
            } else {
                displayClients();
            }   
            clientService.updateClient(client);
            return new ModelAndView(Constants.DISPLAY_CLIENT, Constants.
                CLIENT, client);  
        } catch (EMException e) {
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE,
                String.format(Constants.CLIENT_REMOVE_PROJECT_EXCEPTION, id));
        }
    }
}  
