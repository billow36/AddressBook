package com.ocean.repository.basic;

import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ocean.entity.User;

public class DataHelper extends OrmLiteSqliteOpenHelper {
	private static final String DATABASE_NAME = "AddressBook.db";
	public static int DATABASE_VERSION = 1;
	// we do this so there is only one helper
	private static DataHelper helper = null;
	
	private static final AtomicInteger usageCounter = new AtomicInteger(0);

	public DataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/*
	 * 单例获得示例
	 */
	public static synchronized DataHelper getHelper(Context context) {
		if (helper == null) {
			helper = new DataHelper(context);
		}
		usageCounter.incrementAndGet();
		return helper;
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		try {
			Log.e(DataHelper.class.getName(), "开始创建数据库");
			try {
				TableUtils.createTable(connectionSource, User.class);
				this.getDao(User.class);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}

			Log.e(DataHelper.class.getName(), "创建数据库成功");

		} catch (SQLException e) {
			Log.e(DataHelper.class.getName(), "创建数据库失败", e);
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int arg2, int arg3) {
		System.out.println("onUpgrade()...");
		try {
			try {
				TableUtils.dropTable(connectionSource, User.class, true);
				onCreate(db, connectionSource);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			onCreate(db, connectionSource);
			Log.e(DataHelper.class.getName(), "更新数据库成功");
		} catch (SQLException e) {
			Log.e(DataHelper.class.getName(), "更新数据库失败", e);
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		if (usageCounter.decrementAndGet() == 0) {
			super.close();
			helper = null;
		}
	}
	
	public void GetConn(){
		if(helper!=null){
			helper.getWritableDatabase().beginTransaction();
		}
	}
}
