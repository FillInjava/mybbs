package com.mybbs.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybbs.dao.inter.BaseDao;
@Repository
public class BaseDaoImpl<T> implements BaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		
		if(t instanceof ParameterizedType){
			ParameterizedType type =(ParameterizedType) t;
			this.entityClass =(Class<T>) type.getActualTypeArguments()[0];
		}
	}
	
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    /**
     * @param sessionFactory the sessionFactory to set
     
   
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     */
    /**
     * 
     * @return session
     */
    public Session getSession() {
        //获取当前的CurrentSession
        return sessionFactory.getCurrentSession();
    }
    
	public void save(T t) {
		this.getSession().save(t);
	}
    
	public void saveOrUpdate(T t) {
		this.getSession().saveOrUpdate(t);
	}
    
	public T load(int id) {
		return (T) this.getSession().load(getEntityClass(),id);
	}
    
	public T get(int id) {
		
		return (T) this.getSession().get(getEntityClass(), id);
	}
    
	public boolean contains(T t) {
		return this.getSession().contains(t);
	}
    
	public void delete(T t) {
		this.getSession().delete(t);
	}
  /**
   * @param Id 
   */
	public boolean deleteById(int Id) {
		T t = this.get(Id);
		if(t==null)
			return false;
		this.getSession().delete(t);
		return true;
	}
	/**
	 * 删除指定集合中的
	 */
	public void deleteAll(Collection<T> entities) {
		for(T t:entities)
			this.delete(t);
	}
	/**
	 * 根据hql来查询
	 * @param hqlString hql语句
	 * @param values 查询条件
	 */
	public void queryHql(String hqlString, Object[] values) {
		Query query = this.getSession().createQuery(hqlString);
		
		if(values!=null && values.length>0){
			for(int i=0,z=values.length;i<z;i++){
				query.setParameter(i, values[i]);
			}
		}
		
		query.executeUpdate();
	}
	/**
	 * ִ��SQL���
	 * @param sqlString
	 * @param values ������������
	 */
	public void querySql(String sqlString, Object[] values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		
		if(values!=null && values.length>0){
			for(int i=0,z=values.length;i<z;i++){
				query.setParameter(i, values[i]);
			}
		}
		
		query.executeUpdate();
	}

	/**
	 * ���HQL����ѯ������Ψһʵ��
	 * @param hqlString
	 * @param values ������������
	 */
	public T getByHQL(String hqlString, Object[] values) {
		Query query = this.getSession().createQuery(hqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
	
		return (T) query.uniqueResult();
	}
	/**
	 * ���SQL����ѯ������Ψһʵ��
	 * @param sqlString
	 * @param values ������������
	 */
	public T getBySQL(String sqlString, Object[] values) {
		Query query = this.getSession().createSQLQuery(sqlString);
				
				if(values!=null && values.length>0){
					for(int i=0,z=values.length;i<z;i++){
						query.setParameter(i, values[i]);
					}
				}
		
		return (T) query.uniqueResult();
	}
	/**
     * <���HQL��䣬�õ���Ӧ��list>
     * @param hqlString HQL���
     * @param values ���������Object����
     * @return ��ѯ���ʵ���List����
     */
	public List<T> getListByHQL(String hqlString, Object[] values) {
		Query query = this.getSession().createQuery(hqlString);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
	
		return query.list();
	}
	/**
     * <���SQL��䣬�õ���Ӧ��list>
     * @param sqlString HQL���
     * @param values ���������Object����
     * @return ��ѯ���ʵ���List����
     */
	public List<T> getListBySQL(String sqlString, Object[] values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		
		if(values!=null && values.length>0){
			for(int i=0,z=values.length;i<z;i++){
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	public void refresh(T t) {
		this.getSession().refresh(t);
	}

	public void update(T t) {
		this.getSession().update(t);
	}
	/**
     * <���HQL�õ���¼��>
     * @param hql HQL���
     * @param values ���������Object����
     * @return ��¼����
     */
	public Long countByHql(String hql, Object[] values) {
		Query query = this.getSession().createQuery(hql);
		if(values!=null && values.length>0){
			for(int i =0;i<values.length;i++)
				query.setParameter(i, values[i]);
		}
	
		return (long) query.list().size();
	}
	

}
