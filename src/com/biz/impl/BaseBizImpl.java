package com.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.biz.BaseBiz;
import com.dao.BaseDao;
public class BaseBizImpl<T, PK extends Serializable> implements BaseBiz<T, PK> {
	
	private BaseDao<T, PK> baseDao;
	

	public BaseDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public T load(PK id) {
		return baseDao.load(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		return baseDao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> get(PK[] ids) {
		return baseDao.get(ids);
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(String propertyName, Object value) {
		return baseDao.get(propertyName,value);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getList(String propertyName, Object value) {
		return baseDao.getList(propertyName, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer getAllCount() {
		return baseDao.getCount();
	}

	/**
	 * {@inheritDoc}
	 */
	public PK save(T entity) {
		return baseDao.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveOrUpdate(T entity) {
		baseDao.saveOrUpdate(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(T entity) {
		baseDao.update(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void merge(T entity) {
		baseDao.merge(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(PK id) {
		baseDao.delete(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(PK[] ids) {
		baseDao.delete(ids);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(List<T> list) {
		baseDao.delete(list);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> list() {
		return baseDao.list();
	}

}
