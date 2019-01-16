package com.btb.user.dao;

import com.btb.user.model.User;
import com.btb.util.dao.Dao;

public interface UserDao extends Dao<User> {
	
	/**
	 * 根据用户名查询并返回该用户，否则返回NULL
	 * @param name 用户名
	 * @return 用户或空
	 */
	public User comparisonUser(String name);

}
