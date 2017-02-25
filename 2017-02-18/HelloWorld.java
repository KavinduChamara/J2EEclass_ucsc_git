package pk1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloWorld extends HttpServlet{

		String message="";

	public void init() throws ServletException{
		message="HelloWorld from servlet";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			response.setContentType("text/html");

			// Actual logic goes here

			PrintWriter out=response.getWriter();
			out.println("<h1>" + message + "</h1>");

		}

		public void destroy(){
			// do nothing

		}

}

