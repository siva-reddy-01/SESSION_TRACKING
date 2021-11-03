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
@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet 
{
	
	@SuppressWarnings("unused")
	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		if(session!=null)
		{
			String uname=(String)session.getAttribute("uname");
			out.println("<h2 align=center>User Home Page</h2><br>");
			out.println("<b>Welcome:</b>"+uname+"<br><br>");
			out.println(session.getId()+"<br><br>");
			out.println(session.getMaxInactiveInterval()+"<br><br>");
			
			RequestDispatcher rd=request.getRequestDispatcher("UserHomeServlet.html");
		}
		else
		{
			out.println("<h2 algin=center>Session Experied!</h2><br>");
			
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		
	   	
	}
	
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}

}
