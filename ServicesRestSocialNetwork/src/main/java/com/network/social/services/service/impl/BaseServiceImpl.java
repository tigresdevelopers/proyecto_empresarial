package com.network.social.services.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import com.network.social.services.dao.BaseDao;
import  com.network.social.services.service.BaseService;
/**
 * 
 * @author Alexander Chavez Simbron
 *
 * @param <T>
 * @param <E>
 */
public  class BaseServiceImpl<T,E extends Serializable> implements BaseService<T, E> {

private BaseDao<T, E> dao;

	//Constructor for initialize the DAO
	public BaseServiceImpl(BaseDao<T,E> dao){
		this.dao=dao;
	}

	//Implement methods
	
	@Override
	public void deleteAll(Collection<T> instances){
		try {
			dao.deleteAll(instances);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int bulkUpdate(String query){
		try {
			return dao.bulkUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void saveOrUpdateAll(Collection<T> instances){
		try {
			dao.saveOrUpdateAll(instances);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveCollection(List<T> instances){
		try {
			dao.saveCollection(instances);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public E save(T instance){
		try {
			return dao.save(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveOrUpdate(T instance){
		try {
			dao.saveOrUpdate(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void persist(T transientInstance){
		try {
			dao.persist(transientInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(T instance){
		try {
			dao.update(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T persistentInstance){
		try {
			dao.delete(persistentInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> findByExample(T instance) {
		return dao.findByExample(instance);
	}

	@Override
	public List<T> findByQuery(String query) {
		return dao.findByQuery(query);
	}

	@Override
	public List<Map<String, Object>> findMapByQuery(String queryString) {
		return dao.findMapByQuery(queryString);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return dao.findByCriteria(criteria);
	}

	@Override
	public T merge(T detachedInstance){
		try {
			return dao.merge(detachedInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detachedInstance;
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) {
		try {
			return dao.executeQuery(query, nativeSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,boolean nativeSQL) {
		try {
			return dao.executeQuery(query, parameters,nativeSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<T> listCriterion(List<Criterion> listCriterion) {
		return dao.listCriterion(listCriterion);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public T findById(E id) {
		return dao.findById(id);
	}

	@Override
	public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type) {
		return dao.getByHQL(hql, parameters, type);
	}

	@Override
	public List<T> listHQL(String hql, Map<String, Object> parameters,Class<T> oClass) {
		return dao.listHQL(hql, parameters, oClass);
	}

	@Override
	public List<T> listSQL(String sql, Map<String, Object> parameters,Class<T> oClass) {
		return dao.listHQL(sql, parameters, oClass);
	}

	@Override
	public List<Map<String, Object>> return_cursor(String procedureName,Object... params) {
		return dao.return_cursor(procedureName,params);
	}

	public BaseDao<T, E> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T, E> dao) {
		this.dao = dao;
	}
	
}
