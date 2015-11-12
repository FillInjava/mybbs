package com.mybbs.dao.inter;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

public interface BaseDao<T> {
	/**
     * <����ʵ��>
     * <�����ʵ��>
     * @param t ʵ�����
     */
    public abstract void save(T t);
 
    /**
     * <������߸���ʵ��>
     * @param t ʵ��
     */
    public abstract void saveOrUpdate(T t);
 
    /**
     * <load>
     * <����ʵ���load����>
     * @param id ʵ���id
     * @return ��ѯ������ʵ��
     */
    public abstract T load(int id);
 
    /**
     * <get>
     * <���ҵ�get����>
     * @param id ʵ���id
     * @return ��ѯ������ʵ��
     */
    public abstract T get(int id);
 
    /**
     * <contains>
     * @param t ʵ��
     * @return �Ƿ��
     */
    public abstract boolean contains(T t);
 
    /**
     * <delete>
     * <ɾ����е�t���>
     * @param t ʵ��
     */
    public abstract void delete(T t);
 
    /**
     * <���IDɾ�����>
     * @param Id ʵ��id
     * @return �Ƿ�ɾ��ɹ�
     */
    public abstract boolean deleteById(int Id);
 
    /**
     * <ɾ������>
     * @param entities ʵ���Collection����
     */
    public abstract void deleteAll(Collection<T> entities);
     
    /**
     * <ִ��Hql���>
     * @param hqlString hql
     * @param values ������������
     */
    public abstract void queryHql(String hqlString, Object[] values); 
     
    /**
     * <ִ��Sql���>
     * @param sqlString sql
     * @param values ������������
     */
    public abstract void querySql(String sqlString, Object[] values); 
 
    /**
     * <���HQL������Ψһʵ��>
     * @param hqlString HQL���
     * @param values ���������Object����
     * @return ��ѯʵ��
     */
    public abstract T getByHQL(String hqlString, Object[] values);
 
    /**
     * <���SQL������Ψһʵ��>
     * @param sqlString SQL���
     * @param values ���������Object����
     * @return ��ѯʵ��
     */
    public abstract T getBySQL(String sqlString, Object[] values);
 
    /**
     * <���HQL��䣬�õ���Ӧ��list>
     * @param hqlString HQL���
     * @param values ���������Object����
     * @return ��ѯ���ʵ���List����
     */
    public abstract List<T> getListByHQL(String hqlString, Object[] values);
 
    /**
     * <���SQL��䣬�õ���Ӧ��list>
     * @param sqlString HQL���
     * @param values ���������Object����
     * @return ��ѯ���ʵ���List����
     */
    public abstract List<T> getListBySQL(String sqlString, Object[] values);
     
    
    /**
     * <refresh>
     * @param t ʵ��
     */
    public abstract void refresh(T t);
 
    /**
     * <update>
     * @param t ʵ��
     */
    public abstract void update(T t);
 
    /**
     * <���HQL�õ���¼��>
     * @param hql HQL���
     * @param values ���������Object����
     * @return ��¼����
     */
    public abstract Long countByHql(String hql, Object[] values);
     
}
