package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/CookiesDemoServlet")
public class CookiesDemoServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		
		Cookie ck1=new Cookie("eid",eid);
		Cookie ck2=new Cookie("ename",ename);
		
		ck1.setMaxAge(10);//10 seconds
		ck2.setMaxAge(10);//10 seconds
		
		response.addCookie(ck1);
		response.addCookie(ck2);
		
		response.sendRedirect("ViewCookieServlet");
		
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
         doPost(request, response);
	}

}
