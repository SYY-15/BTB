package com.btb.sys.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.btb.sys.user.dao.UserDao;
import com.btb.sys.user.dao.impl.UserDaoImpl;
import com.btb.sys.user.model.User;

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
    	//response.setContentType("text/html;charset=UTF-8");
    	//response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("application/json;charset=utf-8");
    	PrintWriter printWriter = response.getWriter();
    	JSONObject jsonObject = new JSONObject();
    	User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        System.out.println(user);
        UserDao userDaoImpl = new UserDaoImpl();
        try {
			if(userDaoImpl.comparisonUser(user.getName()) != null) {
				//request.setAttribute("sb", "当前用户名已存在");
				jsonObject.put("mgs", "当前用户名已存在");
			}else {
				userDaoImpl.insert(user);
				//request.setAttribute("cg", "注册成功");
				jsonObject.put("mgs", "注册成功");
			}
			printWriter.println(jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//request.setAttribute("cg", "数据库异常");
		}
        
		//request.getRequestDispatcher("Register.jsp").forward(request, response);
        
	}

}
