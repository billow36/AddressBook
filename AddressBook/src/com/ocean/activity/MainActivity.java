package com.ocean.activity;

import android.os.Bundle;
import android.view.Menu;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.ocean.repository.basic.DataHelper;

public class MainActivity extends OrmLiteBaseActivity<DataHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
