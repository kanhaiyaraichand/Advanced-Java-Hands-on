package com.org.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.login.bean.LoginBean;
import com.org.login.database.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LoginDao  loginDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	loginDao = new LoginDao();
    	
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if(loginDao.validate(loginBean)) {
				response.sendRedirect("loginsuccess.jsp");
				//RequestDispatcher dis = request.getRequestDispatcher("loginsuccess.jsp");
				//dis.forward(request, response);
			} else {
				//HttpSession session = request.getSession();
				//RequestDispatcher dis = request.getRequestDispatcher("loginErr.jsp");
				//dis.forward(request, response);
				response.sendRedirect("loginErr.jsp");
				
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
