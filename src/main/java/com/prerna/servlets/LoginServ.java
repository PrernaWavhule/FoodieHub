package com.prerna.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prerna.daoImpl.UsersDAOImpl;
import com.prerna.database.DB_Connection;
import com.prerna.model.Users;

@WebServlet("/Login")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UsersDAOImpl udao =new UsersDAOImpl();
		Users user = udao.loginUser(email, password);
		
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			// ✅ update last_login
	        try {
	            String updateQuery = "UPDATE users SET LastLogInDate = CURRENT_TIMESTAMP WHERE email = ?";
	            Connection con = DB_Connection.getConnection();
	            PreparedStatement ps = con.prepareStatement(updateQuery);
	            ps.setString(1, email);
	            ps.executeUpdate();
	        } 
	        catch(Exception e) {
	            e.printStackTrace();
	        }
			
			req.getRequestDispatcher("/Home").forward(req, resp);
		
		}
		
		else {
			req.setAttribute("errorMsg", "Invalid email or password");
			req.getRequestDispatcher("invalidlogin.jsp").forward(req, resp);
		}
	}

}
