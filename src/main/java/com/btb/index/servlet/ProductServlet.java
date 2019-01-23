package com.btb.index.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btb.index.dao.ProductDao;
import com.btb.index.dao.impl.ProductDaoImpl;
import com.btb.index.model.Product;
import com.btb.util.page.PageList;
import com.btb.util.string.StringUtils;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String currentPageStr = request.getParameter("page");
		int currentPage = 1;
		if(!StringUtils.isEmpty(currentPageStr)) {
			try {
				currentPage = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Message message = new Message();
		ProductDao dao = new ProductDaoImpl();
		//List<Product> list = dao.findList();
		PageList<Product> pageList = dao.pageList(currentPage);
		//message.setData(list);
		//message.setData(list);
		printWriter.println(pageList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
