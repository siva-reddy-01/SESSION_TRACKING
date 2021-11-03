package url_rewriting;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/GetValuesServlet")
public class GetValuesServlet extends HttpServlet
{
	
	@SuppressWarnings("unused")
	public  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");//eid is the feild in the HTML form
		String ename=request.getParameter("ename");//ename is the feild in the HTML form
		
		out.println(eid+","+ename);
		
		
	}

}
