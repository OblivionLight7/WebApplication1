/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Statement;

/**
 *
 * @author Abhijeet
 */
@WebServlet(urlPatterns = {"/myfirstservlet_"})
public class myfirstservlet_ extends HttpServlet {
private String message;
public void init() throws ServletException {
        message = "Hello VU Students";
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
        

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","Abhijeet@7");
            
            Statement st = con.createStatement();
            
            String query = "Select * From student;";
            ResultSet rs =  st.executeQuery(query);
     
            
            out.print("<h1>Student Table</h1>");
            out.print("<table border = '|' > <tr> <th>rollno</th> <th>name</th> <th> email </th> <th> mobile </th> <th> CG_Marks </th> <th> TOC_Marks </th> <th> DBMS_Marks </th><th> Python_Marks </th> <th> Java_Marks </th></tr> ");
      	  
		        while(rs.next()) {
                            
		                 out.print("<tr><td>");
		        	 out.println(rs.getString(1));
		        	 out.print("</td>");
                                 out.print("<td>");
		           	 out.println(rs.getString(2));
		        	 out.print("</td>");
		        	 out.print("<td>");
		        	 out.print(rs.getString(3));
		        	 out.print("</td>");
		        	 out.print("<td>");
		        	 out.print(rs.getString(4));
		        	 out.print("</td>");
                                 out.print("<td>");
		        	 out.print(rs.getString(5));
		        	 out.print("</td>");
                                 out.print("<td>");
		        	 out.print(rs.getString(6));
		        	 out.print("</td>");
                                 out.print("<td>");
		        	 out.print(rs.getString(7));
		        	 out.print("</td>");
                                 out.print("<td>");
		        	 out.print(rs.getString(8));
		        	 out.print("</td>");
		        	 out.print("<td>");
		        	 out.print(rs.getString(9));
		        	 out.print("</td>");
		        	 out.print("</tr>");
		        	 
		        }   
		      
      	    
 
    }catch(Exception e){
         System.out.println(e.getMessage());
    }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
