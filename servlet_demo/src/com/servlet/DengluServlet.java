package com.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.dao.UserDao;
import com.dao.UserDaolmpl;
 
public class DengluServlet extends HttpServlet { //doGet  doPost方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);  
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //得到jsp页面传过来的参数
		String psd = request.getParameter("psd");
		
		UserDao ud = new UserDaolmpl();
		
		if(ud.login(name, psd)){
			request.setAttribute("xiaoxi", "欢迎用户"+name); 
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else{
			response.sendRedirect("index.jsp"); 
		}
	}
 
}