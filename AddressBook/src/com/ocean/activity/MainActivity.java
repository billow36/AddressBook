package com.ocean.activity;

import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ocean.activity.R;
import com.ocean.common.DataHelper;
import com.ocean.entity.User;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends OrmLiteBaseActivity<DataHelper> {

	Dao<User,Integer> userDao ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			userDao = getHelper().GetUserDao();
			User u = new User();
			u.setUserId("1001");
			u.setPassword("password");
			
			userDao.create(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
