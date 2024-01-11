package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Admin;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String adminemail=req.getParameter("adminemail");
		String adminpassword=req.getParameter("adminpassword");
		
		Dao dao=new Dao();
		try
		{
			Admin admin=dao.FindByEmail(adminemail);
			
			if(admin != null)
			{
				if(admin.getAdminpassword().equals(adminpassword))
				{
					RequestDispatcher rd=req.getRequestDispatcher("ahome.jsp");
					rd.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Password is wrong");
					RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
					rd.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "Email is wrong");
				RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
				rd.include(req, resp);
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
