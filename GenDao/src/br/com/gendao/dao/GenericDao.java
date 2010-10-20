/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gendao.dao;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Barbafh
 */
public interface GenericDao {

    public void save(Object ob);

    public void update(Object ob);

    public void delete(Object ob);

    public List listAll(Class classe, String ordem);

    public List listAll(Class classe, String ordem, String field, String value);

    public List listAll(Class classe, String ordem, String field, int value);

    public Object findOne(Class classe, String field, int value);

    public Object findOne(Class classe, String field, String value);

    public Object findOne(Class classe, String field, float value);

    public Session getSession();
}
