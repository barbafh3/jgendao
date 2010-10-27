/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gendao.dao;

import br.com.gendao.exception.DataAccessLayerException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Barbafh
 */
@Transactional
public class GenericHibernateDao implements GenericDao {

    public SessionFactory sessionFactory;
    private Transaction tx;

    public void saveOrUpdate(Object obj) {
        try {
            startOperation();
            getSession().saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleTransactionException(e);
        } finally {
            getSession().close();
        }
    }

    public void delete(Object obj) {
        try {
            startOperation();
            getSession().delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleTransactionException(e);
        } finally {
            getSession().close();
        }
    }

    public List listAll(Class classe, String ordem) {
        List lista = null;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(classe);
            criteria.addOrder(Order.asc(ordem));
            lista = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            handleTransactionException(e);
        } finally {
            getSession().close();
        }
        return lista;
    }

    public Object findOne(Class classe, String field, int value) {
        Object obj = null;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(classe);
            criteria.add(Restrictions.eq(field, value));
            obj = (Object) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            handleTransactionException(e);
        } finally {
            getSession().close();
        }
        return obj;
    }

    public Object findOne(Class classe, String field, String value) {
        Object obj = null;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(classe);
            criteria.add(Restrictions.eq(field, value));
            obj = (Object) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            handleTransactionException(e);
        } finally {
            getSession().close();
        }
        return obj;
    }

    public Object findOne(Class classe, String field, float value) {
        Object obj = null;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(classe);
            criteria.add(Restrictions.eq(field, value));
            obj = (Object) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            handleTransactionException(e);
        } finally {
            getSession().close();
        }
        return obj;
    }

    public Session getSession() {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
        } catch (HibernateException e) {
            handleStandardException(e);
        }
        return session;
    }

    protected void handleTransactionException(HibernateException e) throws DataAccessLayerException {
        rollback(tx);
        throw new DataAccessLayerException(e);
    }

    protected void handleStandardException(HibernateException e) throws DataAccessLayerException {
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        tx = getSession().beginTransaction();
    }

    protected void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ex) {
            handleStandardException(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
