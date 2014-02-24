
package com.ocean.repository;

import com.ocean.entity.User;
import com.ocean.repository.basic.IOrmLiteDao;


public interface IUserDao extends IOrmLiteDao<User,Integer> {
	
}