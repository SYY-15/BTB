package com.btb.sys.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8"); 
    	PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name + ";" + password);
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://68.168.136.2/btb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
        String user="myuser";
        String daoPassword="MyUser#2018";
        Connection connection = null;
		Statement statement = null;
        ResultSet resultSet = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, daoPassword);
			statement = connection.createStatement();
			String sqlstr = "select * from sys_user where name = '"+name+"'";
			resultSet = statement.executeQuery(sqlstr);
			if(resultSet.next()) {
				request.setAttribute("sb", "当前用户名已存在");
			}else {
				sqlstr="insert into sys_user(password,name) value('"+password+"','"+name+"')";
				System.out.println(sqlstr);
				int n = statement.executeUpdate(sqlstr);
				request.setAttribute("cg", "注册成功");
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
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}

}
