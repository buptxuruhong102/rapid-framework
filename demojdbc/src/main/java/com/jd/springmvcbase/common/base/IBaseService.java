package com.jd.springmvcbase.common.base;

import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;


public interface IBaseService<E,PK extends Serializable>{
	public E getById(PK id) throws DataAccessException;
	
	public List<E> findAll() throws DataAccessException;
	
	/** 根据id检查是否插入或是更新数据 */
	public void saveOrUpdate(E entity) throws DataAccessException;
	
	/** 插入数据 */
	public void save(E entity) throws DataAccessException;
	
	public void removeById(PK id) throws DataAccessException;
	
	public void update(E entity) throws DataAccessException;
	
	public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException;
	
}
