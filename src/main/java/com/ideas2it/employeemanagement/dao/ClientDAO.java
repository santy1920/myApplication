package com.ideas2it.employeemanagement.dao;

import java.util.List;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Client;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on project data such as add, update, remove and search
 * on client details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface ClientDAO { 
    
    /**
     * <p>
     * This method is used to add the client
     * details to the list.
     * </p>
     *
     * @return boolean returns true if the details of client
     * is added to the list.
     */
    public boolean insertClient(Client client) throws EMException;

    /**
     * <p>
     * This method is used to return the client
     * details from the list.
     * </p>
     *
     * @return Client returns clientDetails.
     */ 
    public List<Client> getAllClients() throws EMException;

    /**
     * <p>
     * This method is used to find the client Id
     * and delete its details from the list.
     * </p>
     *
     * @param clientId Id of the client.
     *
     * @return boolean either true or false.
     */
    public boolean deleteClient(Client client) throws EMException;
    
    /**
     * <p>
     * This method is used to update the client
     * details in the list.
     * </p>
     *
     * @return true if client is updated.
     */ 
    public boolean updateClient(Client client) throws EMException;

    /**
     * <p>
     * This method is used to search the particular client
     * detail in the list.
     * </p> 
     *
     * @param clientId int contains Id of the client.
     *
     * @return Client details of the client.
     */
    public Client searchClient(int clientId) throws EMException;

}
