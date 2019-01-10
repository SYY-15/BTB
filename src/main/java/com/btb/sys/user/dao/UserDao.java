package com.btb.sys.user.dao;

import com.btb.sys.user.model.User;
import com.btb.util.dao.Dao;

public interface UserDao extends Dao<User> {
	
	public User comparisonUser(String name) throws Exception;

}
