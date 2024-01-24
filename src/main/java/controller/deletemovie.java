package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
@WebServlet("/deletemovie")
public class deletemovie extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int movieid=Integer.parseInt(req.getParameter("movieid"));
		
		Dao dao=new Dao();
		
		try
		{
			HttpSession session=req.getSession();
			String adminname=(String)session.getAttribute("adminname");
			if(adminname!=null)
			{
				dao.DeleteMovie(movieid);
				req.setAttribute("movies", dao.GetAllMovies());
				
				RequestDispatcher rd=req.getRequestDispatcher("ahome.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Access Denied,Plesae Log in");
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
		catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
