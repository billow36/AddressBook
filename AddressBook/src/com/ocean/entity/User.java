package com.ocean.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SYSUSER")

public class User {
	
	@DatabaseField(columnName="ID",generatedId=true)
	//@DatabaseField(id = true)
	private int Id;
	
	@DatabaseField(unique = true,columnName="USER_ID")
	private String userId;
	
	@DatabaseField(columnName="PASSWORD",canBeNull=false)
	private String password;
	
	@DatabaseField(columnName="USER_NAME")
	private String userName;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
