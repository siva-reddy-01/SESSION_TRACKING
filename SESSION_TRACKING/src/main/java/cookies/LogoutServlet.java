package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie[] cks=request.getCookies();
		
		cks[0].setMaxAge(0);
		cks[1].setMaxAge(1);
		
		response.addCookie(cks[0]);
		response.addCookie(cks[1]);
		
		out.println("<h2 align=center>Logout sucuessfully!!</h2>");
		
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doPost(request, response);
	}

}
