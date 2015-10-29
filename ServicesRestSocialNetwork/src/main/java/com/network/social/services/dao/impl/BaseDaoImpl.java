package com.network.social.services.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.network.social.services.dao.BaseDao;
import com.network.social.services.util.JDBCRow;
import com.network.social.services.util.JDBCUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/**
 * 
 * @author Alexander Chavez Simbron
 *
 * @param <T>
 * @param <E>
 */
@Repository
@Transactional(readOnly=true)
@SuppressWarnings("unchecked")
public abstract  class BaseDaoImpl<T,E extends Serializable> implements BaseDao<T,E> {

	@Autowired(required=true)
	private SessionFactory sessionFactory;

	private final Class<T> oClass;


    public BaseDaoImpl(){
        this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void deleteAll(Collection<T> instances) throws Exception {
		Session session=getSessionFactory().getCurrentSession();
		for (T instance : instances) {
			session.delete(instance);
		}
	}

	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public int bulkUpdate(String query) throws Exception {
		return new HibernateTemplate(getSessionFactory()).bulkUpdate(query);
	}

	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void saveOrUpdateAll(Collection<T> instances) throws Exception {
		Session session=getSessionFactory().getCurrentSession();
		for (T instance : instances) {
			session.saveOrUpdate(instance);
		}
	}

	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void saveCollection(List<T> instances) throws Exception {
		Session session=getSessionFactory().getCurrentSession();
		for (T instance : instances) {
			session.save(instance);
		}
		
	}

	@Override
	@Transactional(readOnly=false)
	public E save(T instance) throws Exception {
		Session session=getSessionFactory().getCurrentSession();
		return (E)session.save(instance);
	}

	@Override
	@Transactional(readOnly=false)
	public void saveOrUpdate(T instance) throws Exception {
		getSessionFactory().getCurrentSession().saveOrUpdate(instance);
	}

	@Override
	@Transactional(readOnly=false)
	public void persist(T transientInstance) throws Exception {
		getSessionFactory().getCurrentSession().persist(transientInstance);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(T instance) throws Exception {
		getSessionFactory().getCurrentSession().update(instance);
	};
	
	@Override
	@Transactional(readOnly=false)
	public void delete(T persistentInstance) throws Exception {
		getSessionFactory().getCurrentSession().delete(persistentInstance);
	}

	@Override
	@Transactional
	public List<T> findByQuery(String query){
		return (List<T>)getSessionFactory().getCurrentSession()
				.createQuery(query).list();
	}

	@Override
	@Transactional
	public List<Map<String, Object>> findMapByQuery(String queryString){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<T> findByCriteria(DetachedCriteria criteria){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public T merge(T detachedInstance) throws Exception {
		return (T)getSessionFactory().getCurrentSession().merge(detachedInstance);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		   if (nativeSQL) {
	            return getSessionFactory().getCurrentSession().createSQLQuery(query).executeUpdate();
	        } else {
	            return getSessionFactory().getCurrentSession().createQuery(query).executeUpdate();
	        }
	}
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public int executeQuery(String query, Map<String, Object> parameters,boolean nativeSQL) {
		 Session ses = getSessionFactory().getCurrentSession();
	        Query q;
	        if (nativeSQL) {
	            q = ses.createSQLQuery(query);
	        } else {
	            q = ses.createQuery(query);
	        }
	        if (parameters != null) {
	            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
	                q.setParameter(entry.getKey(), entry.getValue());
	            }
	        }
	        return q.executeUpdate();
	}
	
	@Override
	@Transactional
	public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type){
		  Query que = getSessionFactory().getCurrentSession().createQuery(hql);
	        if (parameters != null) {
	            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
	                que.setParameter(entry.getKey(), entry.getValue());
	            }
	        }
	        if (type != null) {
	            que.setResultTransformer(Transformers.aliasToBean(type));
	        }
	        T obj = (T) que.uniqueResult();
	        Hibernate.initialize(obj);
	        return obj;
	};
	
	@Override
	@Transactional
    public List<T> listHQL(String hql, Map<String, Object> parameters, Class<T> clazz) {
        Query query;
        if (clazz == null) {
            query = getSessionFactory().getCurrentSession().createQuery(hql);
        } else {
            query = getSessionFactory().getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(clazz));
        }
        if (parameters != null) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.list();
    }


	@Override
    @Transactional
    public List<T> listSQL(String sql, Map<String, Object> parameters,Class<T> clazz) {
        Query query;
        if (clazz == null) {
            query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
        } else {
            query = getSessionFactory().getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(clazz));
        }
        if (parameters != null) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.list();
    }
    
	@Override
	@Transactional
	public  List<T> findAll(){
		return getSessionFactory().getCurrentSession().createCriteria(oClass).list();
	}

	@Override
	@Transactional
	public  T findById(E id){
		return (T)getSessionFactory().getCurrentSession().get(oClass, id);
	}

	@Override
	@Transactional
	public  List<T> findByExample(T instance){
		Example example=Example.create(oClass);
		return getSessionFactory().getCurrentSession()
				.createCriteria(oClass).add(example).list();
	}

	@Override
	@Transactional
	public  List<T> listCriterion(List<Criterion> listCriterion){
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(oClass);
		for (int i = 0; i < listCriterion.size(); i++) {
			criteria.add(listCriterion.get(i));
		}
		return criteria.list();
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public List<Map<String, Object>> return_cursor(String procedureName,Object... params){
		
		String query="BEGIN "+procedureName+" ; END;";
		CallableStatement callstm = null;
        StatelessSession session = getSessionFactory().openStatelessSession();
        Transaction trans = session.beginTransaction();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
          
        try {
		        	Connection cn=session.connection();
		            callstm =cn.prepareCall(query);
		            
		            for (int i =0; i < params.length; i++) {
							callstm.setObject(i+1,params[i]);
					}
		            
		            callstm.registerOutParameter(params.length+1,OracleTypes.CURSOR);
	
		            callstm.execute();

		            ResultSet resultset=((OracleCallableStatement)callstm).getCursor(params.length+1);

		            ResultSetMetaData resultSetMetaData = resultset.getMetaData();

		            while (resultset.next()) {
		                
		                Map<String, Object> row = new HashMap<String, Object>();
		                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
		                    int columnindex = i + 1;

		                    JDBCRow colum = new JDBCRow();
		                    colum.setFieldKey(resultSetMetaData.getColumnName(columnindex));
		                    String columntype = resultSetMetaData.getColumnTypeName(columnindex);
		                    try {
								if (JDBCUtils.fn_oColumnData(resultset, columntype, columnindex)!= null) 
									colum.setFieldValue(JDBCUtils.fn_oColumnData(resultset, columntype, columnindex));
							} catch (Exception e) {
								e.printStackTrace();
							}
		                    
		                    row.put(colum.getFieldKey().toLowerCase(),colum.getFieldValue());
		                }
		                rows.add(row);
		            }

		        } catch (SQLException ex) {
		           ex.printStackTrace();
		        }
		        trans.commit();
		        session.close();
		        return rows;

	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
