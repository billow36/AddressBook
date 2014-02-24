package com.ocean.repository.basic;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.ocean.entity.User;

import android.content.Context;

public class OrmLiteDao<T, ID> implements IOrmLiteDao<T, ID> {

	Dao<T, ID> dao;

	public OrmLiteDao(Context context) {
		
		try {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			dao = DataHelper.getHelper(context).getDao(clazz);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int delete(T object) throws SQLException {
		// TODO Auto-generated method stub
		return dao.delete(object);
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int executeSql(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return dao.executeRawNoArgs(sql);

	}

	@Override
	public List<T> find() throws SQLException {
		// TODO Auto-generated method stub
		return dao.queryForAll();

	}

	@Override
	public T findById(ID id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.queryForId(id);
	}

	@Override
	public int save(T object) throws SQLException {
		// TODO Auto-generated method stub
		return dao.create(object);

	}

	@Override
	public T saveOrUpdate(T object) throws SQLException {
		// TODO Auto-generated method stub
		return dao.createIfNotExists(object);
	}

	@Override
	public int update(T object) throws SQLException {
		// TODO Auto-generated method stub
		return dao.update(object);
	}

}
