package com.ideas2it.employeemanagement.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.dao.UserDAO;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.User;
import com.ideas2it.employeemanagement.util.HibernateUtil;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on user data such as add, remove and search user details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class UserDAOImpl implements UserDAO {

    /**
     * {@inheritDoc}
     */
    public boolean insertUser(User user) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }

            throw new EMException(String.format
                (Constants.USER_ADDITION_EXCEPTION, user.getId()), e);            
        } finally {
            HibernateUtil.close(session); 
        }
    }

    /**
     * @{inheritdoc}
     */
    public User searchUser(String emailId) throws EMException {
        User user = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.like(Constants.EMAILID, emailId));
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            user = (User)criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new EMException(String.format
                (Constants.USER_SEARCH_EXCEPTION, emailId), e);
        } finally {
            HibernateUtil.close(session);
        }
        return user;
    }
} 
