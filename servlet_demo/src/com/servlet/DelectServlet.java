package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaolmpl;


public class DelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String userid = request.getParameter("id");
		UserDao uo = new UserDaolmpl();
		
		int id = Integer.parseInt(userid);
		if(uo.delect(id)) {
			request.setAttribute("baby", "É¾³ý³É¹¦");
			request.getRequestDispatcher("/Searchall").forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}

	}

}
