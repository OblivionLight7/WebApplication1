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
@WebServlet(urlPatterns = {"/myfirstservlet_delete"})
public class myfirstservlet_delete extends HttpServlet {
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
        
        String rollno = request.getParameter("rollno");
        

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
        out.println("<h2> Roll No : " + rollno + "</h2>");
        
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","Abhijeet@7");
            Statement st = con.createStatement();
            
            String query = "DELETE from student WHERE rollno = '" + rollno + "'";
  
      PreparedStatement preparedSt = con.prepareStatement(query);
      
      preparedSt.executeUpdate();
      out.println("<h2>" +"Data Deleted suffessfully of Roll No. : "+ rollno +"</h2>");
      
    }catch(Exception e){
         System.out.println(e.getMessage());
    }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
