package com.btb.sys.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.btb.sys.user.model.User;
import com.btb.util.dao.GenericDao;

public class UserDaoImpl extends GenericDao<User> {

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

}
