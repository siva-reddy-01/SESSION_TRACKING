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
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginCheckServlet extends HttpServlet 
{
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		if(uname.equals("siva") && upwd.equals("123"))
		{
			Cookie ck1=new Cookie("uname",uname);
			Cookie ck2=new Cookie("upwd",upwd);
			
			ck1.setMaxAge(15);//15 seconds
			ck2.setMaxAge(15);// 15 seconds
			
			response.addCookie(ck1);
			response.addCookie(ck2);
			
			response.sendRedirect("UserHome");
		}
		else
		{
		    
			out.println("<h2>Login Invalid!!</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doPost(request, response);
	}

}
