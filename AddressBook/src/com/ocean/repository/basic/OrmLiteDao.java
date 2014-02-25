package com.ocean.repository.basic;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.ocean.entity.User;

import android.content.Context;

public class OrmLiteDao<T, ID> implements IOrmLiteDao<T, ID> {

	Dao<T, ID> dao;
	DataHelper dh ;
	public OrmLiteDao(Context context) {
		
		try {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			dh = DataHelper.getHelper(context);
			dao = dh.getDao(clazz);

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
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeSql(String sql) throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.executeRawNoArgs(sql);

	}

	@Override
	public int executeSql(String sql, String... arguments) throws SQLException {
		// TODO Auto-generated method stub
		return dao.executeRaw(sql, arguments);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		dh.close();		
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
	public int save(List<T> objects) throws SQLException {
		// TODO Auto-generated method stub
		
		return 0;
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
