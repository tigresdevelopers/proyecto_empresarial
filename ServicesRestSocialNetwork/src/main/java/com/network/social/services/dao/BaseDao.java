package com.network.social.services.dao;

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
 * @param <T> Tipo de Objeto
 * @param <E> El Tipo de Id del Objecto
 */
public interface BaseDao<T,E extends Serializable> {

	public void deleteAll(Collection<T> instances) throws Exception;
	
    public int bulkUpdate(String query) throws Exception;
    
    public void saveOrUpdateAll(Collection<T> instances) throws Exception;
    
    public void saveCollection(List<T> instances) throws Exception;
	
    public E save(T instance) throws Exception;
    
    public void saveOrUpdate(T instance) throws Exception;
    
    public void persist(T transientInstance) throws Exception;
    
    public void update(T instance) throws Exception;
    
    public void delete(T persistentInstance) throws Exception;
    
    public List<T> findByExample(T instance);
    
    public List<T> findByQuery(String query);
    
    public List<Map<String, Object>> findMapByQuery(String queryString);
    
    public List<T> findByCriteria(DetachedCriteria criteria);
   
    public T merge(T detachedInstance) throws Exception;

    
 	
	/**
    * Realiza Update a los campos que no sean entidades
    * @param query
    * @param nativeSQL
    * @return Numero de filas afectadas
    * @throws Exception 
    */
    public int executeQuery(String query, boolean nativeSQL) throws Exception;
    
    public int executeQuery(String query, Map<String, Object> parameters, boolean nativeSQL) throws Exception;
	
  
   /**
    * Se debe crear una lista de objetos Criterion de Hibernate: <ul>
    * <code>List(Criterion) listCriterion = new ArrayList();</code> Ejemplos:
    * </ul> <ul> <li> To get records having salary more than 2000 </li>
    * <code>listCriterion.add(Restrictions.gt("salary", 2000));</code>
    *
    * </ul> <ul><li>To get records having salary less than 2000</li>
    * <code>listCriterion.add(Restrictions.lt("salary", 2000));</code> </ul>
    * <ul> <li>To get records having fistName starting with zara</li>
    * <code>listCriterion.add(Restrictions.like("firstName", "zara%"));</code>
    * </ul> <ul> <li>Case sensitive form of the above restriction.</li>
    * <code>listCriterion.add(Restrictions.ilike("firstName", "zara%"));</code>
    * </ul> <ul> <li> To get records having salary in between 1000 and
    * 2000</li>
    * <code>listCriterion.add(Restrictions.between("salary", 1000, 2000));</code>
    * </ul> <ul> <li> To check if the given property is null</li>
    * <code>listCriterion.add(Restrictions.isNull("salary"));</code> </ul> <ul>
    * <li> To check if the given property is not null</li>
    * <code>listCriterion.add(Restrictions.isNotNull("salary"));</code> </ul>
    * <ul> <li> To check if the given property is empty</li>
    * <code>listCriterion.add(Restrictions.isEmpty("salary"));</code> </ul>
    * <ul> <li> To check if the given property is not empty</li>
    * <code>listCriterion.add(Restrictions.isNotEmpty("salary"));</code> </ul>
    *
    * @param listCriterion Lista de restricciones para realizar la consulta.
    * @return Retorna una lista con condiciones dadas.
    */
    public List<T> listCriterion(List<Criterion> listCriterion );
   
   
    /**
     * 
     * @param  procedureName :nombre del Store Procedure
     * @param  params  :array de objects con los parametros
     * @return Retorna una lista con la data del cursor
     */
    public List<Map<String, Object>> return_cursor(String procedureName,Object... params);
    
    public List<T> findAll();
    
    public T findById(E id);
    
    public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type);
    
    public List<T> listHQL(String hql, Map<String, Object> parameters,Class<T> oClass);

  	public List<T> listSQL(String sql, Map<String, Object> parameters,Class<T> oClass);
	
	
}
