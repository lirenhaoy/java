package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaolmpl;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("id");
		int id = Integer.parseInt(userid);
		
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		String home = request.getParameter("home");
		
		UserDao uo = new UserDaolmpl();
		if( uo.update(id, name, psd, home)) {
			request.setAttribute("baby", "更新成功");
			request.getRequestDispatcher("/Searchall").forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
