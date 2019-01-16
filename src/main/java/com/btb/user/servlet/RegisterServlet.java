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
 * Servlet implementation class UserServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		Message message = new Message();
		UserDao userDaoImpl = new UserDaoImpl();
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));

		System.out.println(user);
		if (userDaoImpl.comparisonUser(user.getName()) != null) {
			message.setStatus(false);
			message.setMsg("当前用户名已存在");
		} else {
			userDaoImpl.save(user);
			message.setStatus(true);
			message.setMsg("注册成功");
		}
		printWriter.println(message);

		// request.getRequestDispatcher("Register.jsp").forward(request, response);

	}

}
