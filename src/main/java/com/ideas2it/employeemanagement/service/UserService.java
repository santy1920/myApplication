package com.ideas2it.employeemanagement.service;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.User;

/**
 * <p>
 * This is a Service-Layer interface used to provide functionality classes for 
 * to implement data manipulation operations and business logic 
 * on User Data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface UserService {

    /**
     * <p>
     * This method is used to validate and return the status
     * of user addition to the database.
     * </p>
     *
     * @return userDetails returns true if the details of user
     * is added.
     */ 
    public boolean addUser(User user) throws EMException;
 
    /**
     * <p>
     * This method is used to search the particular user
     * detail in the list.
     * </p> 
     *
     * @param userId Id of the user.
     *
     * @return user details of the user.
     */
    public User searchUser(String emailId) throws EMException;

}
