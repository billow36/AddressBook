package com.ocean.activity;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.ocean.activity.R;
import com.ocean.common.ClassLoaderPlugin;
import com.ocean.entity.User;
import com.ocean.repository.UserDao;
import com.ocean.repository.basic.DataHelper;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends OrmLiteBaseActivity<DataHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UserDao userDao;
		try {
			Set<Class<?>> classes=ClassLoaderPlugin.getClasses("com.ocean.entity");
			Iterator<Class<?>> it = classes.iterator();
			while(it.hasNext()){
				System.out.println("µ±«∞¿‡:"+it.next());
			}
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
