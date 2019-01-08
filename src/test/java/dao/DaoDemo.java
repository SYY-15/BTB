package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DaoDemo {
	
	private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://68.168.136.2/btb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
    private static String user="myuser";
    private static String password="MyUser#2018";
    
    /**
     * 数据库连接
     */
	@Test
	public void connection() {
		Connection connection = null;
		Statement statement = null;
        ResultSet resultSet = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			String sqlstr="insert into sys_user value(10000,'123456','admin')";//into的后面和value前面一定要添加一个空格；value后面与左括号之间有无空格无所谓。
            int n = statement.executeUpdate(sqlstr);
            System.out.println("成功插入"+n+"行");
            sqlstr = "select * from sys_user";
            resultSet = statement.executeQuery(sqlstr);
            while (resultSet.next()) {
				System.out.print(resultSet.getInt(1)+"\t");
				System.out.print(resultSet.getString(2)+"\t");
				System.out.println(resultSet.getString(3));
			}
		}catch(ClassNotFoundException e1)
        {
            System.out.print("数据库驱动不存在！");
            System.out.print(e1.toString());
        }
        catch(SQLException e2)
        {
            System.out.print("数据库存在异常！");
            System.out.print(e2.toString());
        }
        finally
        {
            try
            {
                if(resultSet!=null)
                    resultSet.close();
                if(statement!=null)
                    statement.close();
                if(connection!=null)
                    connection.close();    
            }
            catch(SQLException e)
            {
                System.out.print(e.toString());
            }
        } 
	}
}
