package com.ideas2it.employeemanagement.service;

import java.util.List;
import java.util.Set;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Client;
import com.ideas2it.employeemanagement.model.Project;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes for 
 * to implement data manipulation operations and business logic 
 * on Client Data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface ClientService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of client addition to the database.
     * </p>
     *
     * @return clientDetails returns true if the details of client
     * is added.
     */ 
    public boolean addClient(Client client) throws EMException;
 
    /**
     * <p>
     * This method is used to find the client id
     * and delete its details from the database.
     * </p>
     *
     * @param client client details.
     *
     * @return boolean either true or false.
     */
    public boolean deleteClient(Client client) throws EMException;

    /**
     * <p>
     * This method is used to search the particular client
     * detail in the list.
     * </p> 
     *
     * @param clientId Id of the employee.
     *
     * @return client details of the client.
     */
    public Client searchClient(int clientId) throws EMException;

    /**
     * <p>
     * This method is used to return the client
     * details from the database.
     * </p>
     *
     * @return clients returns clientDetails.
     */ 
    public List<Client> retrieveClients() throws EMException;
    
    /**
     * <p>
     * This method is used to update the client
     * details in the database.
     * </p>
     *
     * @return boolean either true or false.
     */ 
    public boolean updateClient(Client client) throws EMException;
   
    /**
     * <p>
     * This method is used to assign the projects to the particular client
     * and update its details in the database.
     * </p>
     *
     * @param projects Set<Project>
     * @param client Client
     *
     * @return either true or false
     */  
    public boolean assignProjectsToClient(Set<Project> projects,
        Client client) throws EMException;

    /**
     * <p>
     * This method is used to remove the projects of the client 
     * from the database.
     * </p>
     *
     * @param projects Set<Project>
     * @param client Client
     *
     * @return either true or false
     */
    public boolean removeProjectsFromClient(Set<Project> projects,
        Client client) throws EMException;
   
    /**
     * <p>
     * This method is used to retrieve all the projects of the client
     * and return its details from the database.
     * </p>
     *
     * @return List<Project> project details.
     */
    public List<Project> retrieveProjects() throws EMException;

}   
