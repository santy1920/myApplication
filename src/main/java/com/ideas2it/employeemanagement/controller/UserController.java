package com.ideas2it.employeemanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.model.User;
import com.ideas2it.employeemanagement.service.UserService;
import com.ideas2it.employeemanagement.service.impl.UserServiceImpl;
import com.ideas2it.employeemanagement.logger.Logger;
import com.ideas2it.employeemanagement.exception.EMException;

/**
 * <p>
 * User Controller is a Controller class used to create users to make them
 * authorisabale to access the application and allow them to make changes to the
 * available data.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class UserController {

    private UserService userService = new UserServiceImpl();

    /**
     * <p>
     * This method is used to add a new user after getting details
     * of the user and adding them to perform authorisation.
     * </p>
     */
    @RequestMapping(value="/register_user",method=RequestMethod.POST)
    private ModelAndView createUser(@RequestParam(Constants.EMAILID) String emailId,
                            @RequestParam(Constants.PASSWORD) String password) {
        try {            
            User user = new User();
            user.setEmailId(Constants.EMAILID);
            user.setPassword(Constants.PASSWORD);
            user.setActive(Boolean.TRUE);
            if (userService.addUser(user)) {
                return new ModelAndView("index.jsp");
            } else {
                return new ModelAndView(Constants.LOGIN);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE, e.getMessage());
        }
    }   

    /**
     * <p>
     * This method is used to search the particular user from the user list and
     * allow him access to login by creating a session.
     * </p>
     */
    @RequestMapping(value="/login_user",method=RequestMethod.POST)
    private ModelAndView loginUser(@RequestParam(Constants.EMAILID) String emailId, 
                                   @RequestParam(Constants.PASSWORD) String password,
                                   HttpServletRequest request, HttpServletResponse response) {
        User user = null;
        try {
            user = userService.searchUser(Constants.EMAILID);
            if (null != user && password.equals(user.getPassword())) {
                HttpSession session = request.getSession(false);
                session.setAttribute(Constants.USER, user);
			    session.setMaxInactiveInterval(1800);
                return new ModelAndView(Constants.INDEX);
            } else {
                return new ModelAndView(Constants.LOGIN);
            }
        } catch (EMException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR, Constants.ERROR_MESSAGE, e.getMessage());
        }
    }

    /**
     * <p>
     * This method is used to logout the particular user by invalidating his
     * credentials from the session.
     * </p>
     */
    @RequestMapping(value="/logout_user",method=RequestMethod.GET)
    public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(Boolean.FALSE);        
        if (session != null || session.getAttribute(Constants.USER) != null) {
            session.invalidate();
    	    return new ModelAndView(Constants.LOGIN);
        } else {
                return new ModelAndView(Constants.LOGIN);
        }
    }
}
