package com.btb.user.dao;

import com.btb.user.model.User;
import com.btb.util.dao.Dao;

public interface UserDao extends Dao<User> {
	
	public User comparisonUser(String name);

}
