
package com.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.UserDao;
import com.dao.UserDaolmpl;
import com.entity.User;
 
public class Searchall extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao ud = new UserDaolmpl();
		List<User> userAll = ud.getUserAll();
		request.setAttribute("userAll", userAll);
		request.getRequestDispatcher("/showAll.jsp").forward(request, response);
}
}
