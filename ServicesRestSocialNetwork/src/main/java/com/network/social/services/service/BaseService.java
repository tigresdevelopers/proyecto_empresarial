package com.network.social.services.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
/**
 * 
 * @author Alexander Chavez Simbron
 *
 * @param <T>
 * @param <E>
 */
public interface  BaseService<T,E extends Serializable> {

public void deleteAll(Collection<T> instances);
	
    public int bulkUpdate(String query) ;
    
    public void saveOrUpdateAll(Collection<T> instances);
    
    public void saveCollection(List<T> instances);
	
    public E save(T instance) ;
    
    public void saveOrUpdate(T instance);
    
    public void persist(T transientInstance);
    
    public void update(T instance);
     
    public void delete(T persistentInstance);
    
    public List<T> findByExample(T instance);
    
    public List<T> findByQuery(String query);
    
    public List<Map<String, Object>> findMapByQuery(String queryString);
    
    public List<T> findByCriteria(DetachedCriteria criteria);
   
    public T merge(T detachedInstance);

    public int executeQuery(String query, boolean nativeSQL);
    
    public int executeQuery(String query, Map<String, Object> parameters, boolean nativeSQL);

    public List<T> listCriterion(List<Criterion> listCriterion );
   
    public List<Map<String, Object>> return_cursor(String procedureName,Object... params);
    
    public List<T> findAll();
    
    public T findById(E id);
    
    public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type);
    
    public List<T> listHQL(String hql, Map<String, Object> parameters,Class<T> oClass);

  	public List<T> listSQL(String sql, Map<String, Object> parameters,Class<T> oClass);
	
}
