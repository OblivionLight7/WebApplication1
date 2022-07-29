/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Abhijeet
 */
public class MySqlAccess {
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        try
            
    {
      System.out.println("Enter rollno:");
      String rollno =s.next();
      System.out.println("Enter name:");
      String name =s.next();
      System.out.println("Enter email:");
      String email =s.next();
      System.out.println("Enter mobile:");
      String mobile = s.next();
      System.out.println("Enter CG_Marks:");
      String CG_Mark = s.next();
      System.out.println("Enter TOC_Mark:");
      String TOC_Mark =s.next();
      System.out.println("Enter DBMS_Mark:");
      String DBMS_Mark =s.next();
      System.out.println("Enter Python_Mark:");
      String Python_Mark =s.next();
      System.out.println("Enter Java_Mark:");
      String Java_Mark =s.next();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?characterEncoding=UTF-8","root","Abhijeet@7");
      
      String query = " insert into student (rollno, name, email, mobile,CG_Mark,TOC_Mark,DBMS_Mark,Python_Mark,Java_Mark) values (?,?, ?, ?, ?,?,?,?,?)";

      // create the mysql insert preparedstatement
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
      
      int i = preparedSt.executeUpdate();
      if(i!=0){
        System.out.println("Added Data in Database");
      }
      else{
        System.out.println("Failed to add Data in Database");

    }
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        
    }
}
