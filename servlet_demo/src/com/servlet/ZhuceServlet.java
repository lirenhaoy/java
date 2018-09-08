package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaolmpl;
import com.entity.User;


public class ZhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		String home = request.getParameter("home");
		
		User user = new User();
		
		user.setName(name);
		user.setPsd(psd);
		user.setHome(home);
		
		UserDao uo = new UserDaolmpl();
		if(uo.register(user)) {
			request.setAttribute("username", "ע��ɹ�");
			request.getRequestDispatcher("Denglu.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
