
package com.ocean.repository;

import java.util.List;


public interface IBasicDao<T>{
	public boolean delete(T object);
	public boolean deleteAll();
	public boolean executeSql(String sql);
	public List<T> find();
	public T  findById();
	public boolean save(T object);
	public boolean saveOrUpdate(T object);
	public boolean update(T object);
}