package com.btb.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btb.user.dao.UserDao;
import com.btb.user.dao.impl.UserDaoImpl;
import com.btb.user.model.User;
import com.btb.util.msg.Message;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		User user = new User();
		PrintWriter printWriter = response.getWriter();
		user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        System.out.println(user);
        Message message = new Message();
		UserDao userDaoImpl = new UserDaoImpl();
		User user1 = userDaoImpl.comparisonUser(user.getName());
        if (user1 != null) {
        	
        	if(user1.getPassword().equals(user.getPassword())){
        		
        		message.setStatus(1);
        		message.setMsg("成功登录");
        		
        		
        		
        	}else{
        		message.setStatus(3);
        		message.setMsg("密码错误");
        		
        	}
        	
        	
		} else {
			message.setStatus(2);
			message.setMsg("用户名不存在");
		}
		
        printWriter.println(message);
		
	}

}
