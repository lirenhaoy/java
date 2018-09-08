
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'BB.jsp' starting page</title>
  </head>
  <body >
  <form action="ZhuceServlet"method="post" style="padding-top:-700px;">
	   输入用户名:<input name="name" type="text"><br><br>
	   输入密码:<input name="psd" type="password"><br><br>
	   
	   选择家乡:
	   <select name="home">
		   <option value="周口">周口</option>
		   <option value="信阳" selected>信阳</option>
		   <option value="驻马店">驻马店</option>
   		</select><br>
             
	   <input type="reset"value="重置"><input type="submit"value="注册">
   </form>
  </body>
</html>
