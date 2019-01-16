package com.btb.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.btb.user.dao.UserDao;
import com.btb.user.model.User;
import com.btb.util.dao.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int save(User user) {
		int ret = 0;
		String sql = "INSERT INTO sys_user"
                + "(password, name)"
                + "values(?,?)";
        Object[] param = {
        		user.getPassword(),
        		user.getName() };
        try {
			ret = executeSQL(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return ret;
	}
	
	public User comparisonUser(String name) {
    	User user = null;
        Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM sys_user WHERE name=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
			    user.setPassword(resultSet.getString("password"));
			    user.setName(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeAll(connection, statement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
        return user;
    }

	@Override
	public List<User> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
