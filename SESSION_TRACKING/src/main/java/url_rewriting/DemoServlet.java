package url_rewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet 
{
	
	@SuppressWarnings("unused")
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		
		//response.sendRedirect("getvalues?name="+ename+"");//passing one parameter at a time
		
		response.sendRedirect("GetValuesServlet?id="+eid+"&name="+ename+"");//passing two parameters at a time
		
	}

}
