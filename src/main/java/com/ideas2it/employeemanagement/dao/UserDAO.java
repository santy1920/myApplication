package com.ideas2it.employeemanagement.dao;

import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.User;

/**
 * <p>
 * This is a Data-Access-Object Interface for executing data manipulation
 * operation on project data such as add, remove and search user details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public interface UserDAO { 
    
    /**
     * <p>
     * This method is used to add the user details to the database.
     * </p>
     *
     * @return boolean returns true if the details of user
     * is added to the list.
     */
    public boolean insertUser(User user) throws EMException;

    /**
     * <p>
     * This method is used to search the particular user
     * detail in the database.
     * </p> 
     *
     * @param userId int contains Id of the user.
     *
     * @return User details of the user.
     */
    public User searchUser(String emailId) throws EMException;

}
