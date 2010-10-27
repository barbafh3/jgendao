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

    /**
     * Saves or Updates the given object.
     *
     * @Author Gilberto Timotheo Junior
     * @param obj Object to be saved
     */
    public void saveOrUpdate(Object obj);

    /**
     * Removes the given object.
     *
     * @Author Gilberto Timotheo Junior
     * @param obj Object to be removed
     */
    public void delete(Object obj);

    /**
     * Returns a list of all records of a particular class, sorted by a specified field.
     *
     * @Author Gilberto Timotheo Junior
     * @param classe The class type
     * @param ordem the field used to sort the list
     * @return A list of all records of that class
     */
    public List listAll(Class classe, String ordem);

    /**
     * Searches and returns one record from the specified class.
     *
     * @Author Gilberto Timotheo Junior
     * @param classe The class type
     * @param field the field used to restrict the search
     * @param value the value of the field
     * @return The object found by the search
     */
    public Object findOne(Class classe, String field, int value);

    /**
     * Searches and returns one record from the specified class.
     *
     * @Author Gilberto Timotheo Junior
     * @param classe The class type
     * @param field the field used to restrict the search
     * @param value the value of the field
     * @return The object found by the search
     */
    public Object findOne(Class classe, String field, String value);

    /**
     * Searches and returns one record from the specified class.
     *
     * @Author Gilberto Timotheo Junior
     * @param classe The class type
     * @param field the field used to restrict the search
     * @param value the value of the field
     * @return The object found by the search
     */
    public Object findOne(Class classe, String field, float value);

    /**
     * Returns the instance of Session used by this class.
     *
     * @Author Gilberto Timotheo Junior
     * @return The session used by this class
     */
    public Session getSession();
}
