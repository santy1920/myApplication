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
import com.ideas2it.employeemanagement.dao.ProjectDAO;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.util.HibernateUtil;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on project data such as add, update, remove and search.
 * on project details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class ProjectDAOImpl implements ProjectDAO {

    /**
     * {@inheritDoc}
     */
    public boolean insertProject(Project project) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.PROJECT_ADDITION_EXCEPTION, project.getId()), e);            
        } finally {
            HibernateUtil.close(session); 
        }
    } 

    /**
     * {@inheritDoc}
     */
    public boolean updateProject(Project project) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.PROJECT_UPDATE_EXCEPTION, project.getId()), e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteProject(Project project) throws EMException {
        Session session = null;
        Transaction transaction = null;
        boolean isDeleted = Boolean.FALSE;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            project.setActive(Boolean.FALSE);
            session.update(project);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.PROJECT_DELETE_EXCEPTION, project.getId()), e);
        } finally {
            HibernateUtil.close(session);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> getAllProjects() throws EMException {
        Session session = null;
        List<Project> projects = new ArrayList<Project>();
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(Project.class).
                setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            projects = criteria.list();
        } catch (HibernateException e) {
            throw new EMException(e);
        } finally {
            HibernateUtil.close(session);
        }
        return projects;
    }

    /**
     * @{inheritdoc}
     */
    public Project searchProject(int projectId) throws EMException {
        Project project = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(Project.class);
            criteria.add(Restrictions.like(Constants.ID, projectId));
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            project = (Project)criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new EMException(String.format
                (Constants.PROJECT_SEARCH_EXCEPTION, projectId), e);
        } finally {
            HibernateUtil.close(session);
        }
        return project;
    }
}
