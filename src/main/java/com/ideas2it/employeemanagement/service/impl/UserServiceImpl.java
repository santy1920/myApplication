package com.ideas2it.employeemanagement.service.impl;

import com.ideas2it.employeemanagement.dao.UserDAO;
import com.ideas2it.employeemanagement.dao.impl.UserDAOImpl;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.User;
import com.ideas2it.employeemanagement.service.UserService;

/**
 * <p>
 * This is a Service-Layer class, which is used for the purpose
 * of providing Business Logic to operations on user data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    /**
     * @{inheritdoc}
     */
    public boolean addUser(User user) throws EMException {
        return userDAO.insertUser(user);
    }

    /**
     * @{inheritdoc}
     */
    public User searchUser(String emailId) throws EMException {
        return userDAO.searchUser(emailId);
    }

}  
