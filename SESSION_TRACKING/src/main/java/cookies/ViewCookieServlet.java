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
@WebServlet("/ViewCookieServlet")
public class ViewCookieServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie cks[]=request.getCookies();
		
		if(cks!=null)
		{
			for(Cookie ck:cks)//for each  loop
			{
				out.println(ck.getName()+","+ck.getValue()+","+ck.getMaxAge()+"<br>");
			}
		}
		else
		{
			out.println("<b>Cookies Expired!!!!</b>");
			RequestDispatcher rd=request.getRequestDispatcher("employee.html");
			rd.include(request, response);
			
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doPost(request, response);
	}

}
