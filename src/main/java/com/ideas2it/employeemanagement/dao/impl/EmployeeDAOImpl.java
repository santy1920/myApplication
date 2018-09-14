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
import com.ideas2it.employeemanagement.dao.EmployeeDAO;
import com.ideas2it.employeemanagement.exception.EMException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.util.HibernateUtil;

/**
 * <p>
 * This is a Data-Access-Object Class for executing data manipulation
 * operation on employee data such as add, update, remove and search.
 * on employee details.
 * </p>
 *
 * @author Santhosh Kumar
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    /**
     *  @{inheritDoc}
     */
    public boolean insertEmployee(Employee employee) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) { 
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.EMPLOYEE_ADDITION_EXCEPTION, employee.getId()), e);
        } finally {
            HibernateUtil.close(session);
        }
        
   }
       
    /**
     *  @{inheritDoc} 
     */
    public boolean deleteEmployee(Employee employee) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            employee.setActive(Boolean.FALSE);
            session.update(employee);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.EMPLOYEE_DELETE_EXCEPTION, employee.getId()), e);           
        } finally {
            HibernateUtil.close(session);
        }
    }
 
    /**
     *  @{inheritDoc}
     */
    public boolean updateEmployee(Employee employee) throws EMException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            return Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
                return Boolean.FALSE;
            }
            throw new EMException(String.format
                (Constants.EMPLOYEE_UPDATE_EXCEPTION, employee.getId()), e);
        } finally {
            HibernateUtil.close(session);
        }
    }
 
    /**
     *  @{inheritDoc}
     */
    public List<Employee> getAllEmployees() throws EMException {
        Session session = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(Employee.class).
                setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            employees = criteria.list();
        } catch (HibernateException e) {
            throw new EMException(e);
        } finally {
            HibernateUtil.close(session);
        }
        return employees;
    }

    /**
     *  {@inheritDoc}
     */
    public Employee searchEmployee(int employeeId) throws EMException {
        Employee employee = null;
        Session session = null;
        try {
            session = HibernateUtil.getFactory().openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.like(Constants.ID, employeeId));
            criteria.add(Restrictions.like(Constants.ACTIVE, Boolean.TRUE));
            employee = (Employee)criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new EMException(String.format
                (Constants.EMPLOYEE_SEARCH_EXCEPTION, employeeId), e);
        } finally {
            HibernateUtil.close(session);
        }
        return employee;
    }
}
