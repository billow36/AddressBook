package com.ocean.activity;

import java.sql.SQLException;
import android.os.Bundle;
import android.view.Menu;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.ocean.entity.User;
import com.ocean.repository.UserDao;
import com.ocean.repository.basic.DataHelper;

public class MainActivity extends OrmLiteBaseActivity<DataHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UserDao userDao;
		try {
			userDao = new UserDao(this);
			User u = new User();
			u.setId(1);
			u.setUserId("1001");
			u.setPassword("password");
			userDao.save(u);
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
