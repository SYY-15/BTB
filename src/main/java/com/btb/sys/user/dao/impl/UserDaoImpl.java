package com.btb.sys.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.btb.sys.user.dao.UserDao;
import com.btb.sys.user.model.User;
import com.btb.util.dao.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int insert(User user) throws Exception {
		String sql = "INSERT INTO sys_user"
                + "(password, name)"
                + "values(?,?)";
        Object[] param = { 
        		user.getPassword(),
        		user.getName() };
        return executeSQL(sql, param);
	}
	
	public User comparisonUser(String name) throws Exception {
    	User user = null;
        Connection connection = getConnection();
        String sql = "SELECT * FROM sys_user WHERE name=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	user = new User();
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
        }
        closeAll(connection, statement, resultSet);
        return user;
    }

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
