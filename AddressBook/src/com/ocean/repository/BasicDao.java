package com.ocean.repository;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

public class BasicDao<T> implements IBasicDao<T> {

	public BasicDao(Context context) {
		try {
			DataHelper.getHelper(context).getDao(
					getClass().getGenericSuperclass().getClass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executeSql(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T object) {
		// TODO Auto-generated method stub
		return false;
	}

}
