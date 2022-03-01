<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.org.login.database.*"%>
 <!DOCTYPE html>
 <html>
 <head>
  <meta charset="ISO-8859-1">
   <title>Insert title here</title>
    </head>
	<body>
	<jsp:useBean id="login" class="com.org.login.bean.LoginBean" />
	<jsp:setProperty property="*" name="login" />
	 <%
 		 LoginDao loginDao = new LoginDao();
  		 boolean status = loginDao.validate(login);
   		 if (status) {
           	out.print("<h1>You have logined successfully</h1>");
   		} else {
   			out.print("<h1>user name or password is incurrect</h1>");
   		}
 	%>
  </body>
</html>