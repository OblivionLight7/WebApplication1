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
@WebServlet(urlPatterns = {"/myfirstservlet"})
public class myfirstservlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String CG_Mark = request.getParameter("CG_Mark");
        String TOC_Mark = request.getParameter("TOC_Mark");
        String DBMS_Mark = request.getParameter("DBMS_Mark");
        String Python_Mark = request.getParameter("Python_Mark");
        String Java_Mark = request.getParameter("Java_Mark");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
        out.println("<h2> Roll No : " + rollno + "</h2>");
        out.println("<h2> Name : " + name + "</h2>");
        out.println("<h2> Email : " + email + "</h2>");
        out.println("<h2> Mobile : " + mobile + "</h2>");
        out.println("<h2> CG Mark : " + CG_Mark + "</h2>");
        out.println("<h2> TOC Mark : " + TOC_Mark + "</h2>");
        out.println("<h2> DBMS Mark : " + DBMS_Mark + "</h2>");
        out.println("<h2> Python Mark : " + Python_Mark + "</h2>");
        out.println("<h2> Java Mark : " + Java_Mark + "</h2>");
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","Abhijeet@7");
            
            Statement st = con.createStatement();
            
            String query = " insert into student (rollno, name, email, mobile,CG_Mark,TOC_Mark,DBMS_Mark,Python_Mark,Java_Mark) "
                    + "values (?,?, ?, ?, ?,?,?,?,?)";

      
      PreparedStatement preparedSt = con.prepareStatement(query);
      
      preparedSt.setString (1, rollno);
      preparedSt.setString (2, name);
      preparedSt.setString (3, email);
      preparedSt.setString (4, mobile);
      preparedSt.setString (5, CG_Mark);
      preparedSt.setString (6, TOC_Mark);
      preparedSt.setString (7, DBMS_Mark);
      preparedSt.setString (8, Python_Mark);
      preparedSt.setString (9, Java_Mark);
      preparedSt.executeUpdate();
      
      out.println("<h2>" +"Data added successfully"+ "</h2>");
      
    }catch(Exception e){
         System.out.println(e.getMessage());
    }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
