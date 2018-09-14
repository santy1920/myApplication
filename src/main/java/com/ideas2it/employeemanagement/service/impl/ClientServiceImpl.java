package com.ideas2it.employeemanagement.service.impl;

import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.dao.ClientDAO;
import com.ideas2it.employeemanagement.dao.impl.ClientDAOImpl;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Client;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.ClientService;
import com.ideas2it.employeemanagement.service.impl.ProjectServiceImpl;
import com.ideas2it.employeemanagement.service.ProjectService;

/**
 * <p>
 * This is a Service-Layer class, which is used for the purpose
 * of providing Business Logic to operations on client data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class ClientServiceImpl implements ClientService {
    private ClientDAO clientDAO = new ClientDAOImpl();
    private ProjectService projectService = new ProjectServiceImpl();

    /**
     * @{inheritdoc}
     */
    public boolean addClient(Client client) throws EMException {
        return clientDAO.insertClient(client);
    }
  
    /**
     *  @{inheritDoc}
     */
    public boolean deleteClient(Client client) throws EMException {
        return clientDAO.deleteClient(client);
    }    
 
    /**
     * @{inheritdoc}
     */
    public Client searchClient(int clientId) throws EMException {
        return clientDAO.searchClient(clientId);
    }

    /**
     * @{inheritdoc}
     */ 
    public List<Client> retrieveClients() throws EMException {
        return clientDAO.getAllClients();
    }
  
    /**
     *  {@inheritDoc}
     */
    public List<Project> retrieveProjects() throws EMException {
        return projectService.retrieveProjects();
    }

    /**
     * @{inheritdoc}
     */ 
    public boolean updateClient(Client client) throws EMException {
        return clientDAO.updateClient(client);
    }
    
    /**
     *  {@inheritDoc}
     */
    public boolean assignProjectsToClient(Set<Project> projects,
            Client client)  throws EMException {
        client.setProjects(projects);
        return clientDAO.updateClient(client);
    }

    /**
     *  {@inheritDoc}
     */
    public boolean removeProjectsFromClient(Set<Project> projects,
            Client client)  throws EMException {
        client.getProjects().removeAll(projects);
        return clientDAO.updateClient(client);
    }
}
