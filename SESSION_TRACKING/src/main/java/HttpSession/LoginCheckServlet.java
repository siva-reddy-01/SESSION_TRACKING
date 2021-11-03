package HttpSession;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		if(uname.equals("siva") && upwd.equals("1431"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname",uname);
			session.setAttribute("upwd",upwd);
			session.setMaxInactiveInterval(10);//10 seconds
			response.sendRedirect("UserHomeServlet");	
		}
		else
		{
			out.println("<h2>Login Invalid</h2><br>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doPost(request,response);
	}
	
}
