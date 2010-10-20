/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gendao.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Barbafh
 */
@Transactional
@Repository("genDao")
public class GenericHibernateDao implements GenericDao {

    @Autowired
    public SessionFactory sessionFactory;

    public Session getSession() {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return session;
    }

    public void save(Object ob) {
        Session session = this.getSession();
        session.save(ob);
        session.flush();
        session.close();
    }

    public void update(Object ob) {
        Session session = this.getSession();
        session.update(ob);
        session.flush();
        session.close();
    }

    public void delete(Object ob) {
        Session session = this.getSession();
        session.delete(ob);
        session.flush();
        session.close();
    }

    public List listAll(Class classe, String order) {
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(classe);
        criteria.addOrder(Order.asc(order));
        List list = criteria.list();
        return list;
    }

    public List listAll(Class classe, String order, String field, String value) {
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(classe);
        criteria.addOrder(Order.asc(order));
        criteria.add(Restrictions.eq(field, value));
        return criteria.list();
    }

    public List listAll(Class classe, String order, String field, int value) {
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(classe);
        criteria.addOrder(Order.asc(order));
        criteria.add(Restrictions.eq(field, value));
        return criteria.list();
    }

    public Object findOne(Class classe, String field, int value) {
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(classe);
        criteria.add(Restrictions.eq(field, value));
        Object ob = criteria.uniqueResult();
        session.close();
        return ob;
    }

    public Object findOne(Class classe, String field, String value) {
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(classe);
        criteria.add(Restrictions.eq(field, value));
        Object ob = criteria.uniqueResult();
        session.close();
        return ob;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object findOne(Class classe, String field, float value) {
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(classe);
        criteria.add(Restrictions.eq(field, value));
        Object ob = criteria.uniqueResult();
        session.close();
        return ob;
    }
}
