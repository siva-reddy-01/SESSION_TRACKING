package cookies;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "UserHome", urlPatterns = { "/UserHome" })
public class UserHomeServlet extends HttpServlet 
{
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie[] cks=request.getCookies();
		
		if(cks!=null)
		{
			String uname=cks[0].getValue();
			out.println("<h2 align=center>User Home Page</h2><br>");
			out.println("<b>Welcome:</b>"+uname+"<br><br>");
			
			RequestDispatcher rd=request.getRequestDispatcher("UserHome");
			
			rd.include(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doPost(request, response);
	}

}
