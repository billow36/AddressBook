
package com.ocean.repository;
import java.sql.SQLException;

import com.ocean.entity.User;
import com.ocean.repository.basic.OrmLiteDao;

import android.content.Context;



public class UserDao  extends OrmLiteDao<User,Integer> implements IUserDao {
	
	public UserDao(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return this.executeSql("delete from SYSUSER");
	}
	
}
