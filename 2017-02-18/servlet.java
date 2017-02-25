import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class HelloWorld extends HttpServlet{

	public void init() throws servletException{
		message="HelloWorld from servlet";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws servletException, IOException{
			response.setContentType("text/html");

			// Actual logic goes here

			PrintWriter out=response.getWriter();
			out.println("<h1>" + message + "</h1>");

		}

		public void destroy(){
			// do nothing

		}

}

