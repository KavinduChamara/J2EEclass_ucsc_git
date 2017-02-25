package pk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String DB_URL = "jdbc:mysql://localhost/registration";
	public String DB_USER = "root";
	public String PASSWORD = "";
	//String message1="valid user!!";
	//String message2="Invalid user!!";
       
    //String message="Hello from login servlet";
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		String user=request.getParameter("username");
		String pword=request.getParameter("password");
		
		
		
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(DB_URL,DB_USER,PASSWORD);
			Statement stmt=conn.createStatement();
			
			String valsql="Select user_name,password FROM reg_users WHERE user_name = '" +user+ "' ";
			
			ResultSet rs=stmt.executeQuery(valsql);
			
			while(rs.next()){
			String dbuser=rs.getString("user_name");
			String dbpw=rs.getString("password");
			
			//if(user.matches(dbuser)) && (pword.matches(dbpw)){
			if((user.matches(dbuser)) && (pword.matches(dbpw))){
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request,response);
			}
			else{
				//out.println("<h2>" + message2 + "</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("registration.html");
				rd.include(request,response);
			}	
				
			}
			
			
			
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException sql){
			sql.printStackTrace();
		}
		
			//database connection
	
		
		
		
		
		
		
		
		//out.println("<h2>" + user + "</h2");
		//out.println("<h2>" + pword + "</h2");
	}

}
