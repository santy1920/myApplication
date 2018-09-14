package com.ideas2it.employeemanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.employeemanagement.commons.constants.Constants;
import com.ideas2it.employeemanagement.dao.ClientDAO;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Client;
import com.ideas2it.employeemanagement.util.HibernateUtil;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on project data such as add, update, remove and search.
 * on client details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class ClientDAOImpl implements ClientDAO {

    /**
     * {@inheritDoc}
     */
    public boolean insertClient(Client client) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.CLIENT_ADDITION_EXCEPTION, client.getId()), e);
        } finally {
            HibernateUtil.close(session); 
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateClient(Client client) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.CLIENT_UPDATE_EXCEPTION, client.getId()), e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteClient(Client client) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            client.setActive(Boolean.FALSE);
            session.update(client);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.CLIENT_DELETE_EXCEPTION, client.getId()), e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Client> getAllClients() throws EMException {
        Session session = null;
        Transaction transaction = null;
        List<Client> clients = new ArrayList<Client>();
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(Client.class);
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            clients = criteria.list();
        } catch (HibernateException e) {
            throw new EMException(e);
        } finally {
            HibernateUtil.close(session);
        }
        return clients;
    }

    /**
     * @{inheritdoc}
     */
    public Client searchClient(int clientId) throws EMException {
        Client client = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(Client.class);
            criteria.add(Restrictions.like(Constants.ID, clientId));
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            client = (Client)criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new EMException(String.format
                (Constants.CLIENT_SEARCH_EXCEPTION, clientId), e);
        } finally {
            HibernateUtil.close(session);
        }
        return client;
    }
}
