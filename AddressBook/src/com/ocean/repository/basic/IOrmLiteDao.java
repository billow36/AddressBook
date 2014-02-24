
package com.ocean.repository.basic;

import java.sql.SQLException;
import java.util.List;


public interface IOrmLiteDao<T,ID>{
	public int delete(T object) throws SQLException;
	public boolean deleteAll();
	public int executeSql(String sql) throws SQLException;
	public List<T> find() throws SQLException;
	public T  findById(ID id) throws SQLException;
	public int save(T object) throws SQLException;
	public T  saveOrUpdate(T object) throws SQLException;
	public int update(T object) throws SQLException;
}