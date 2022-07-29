/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author Abhijeet
 */
public class MySqlAccess2 {
    public static void main(String[] args)
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?characterEncoding=UTF-8","root","Abhijeet@7");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * From student");
            System.out.println("Below is the Data in Student Database --\n");
            while(rs.next())
            {
                
                System.out.println(rs.getString("rollno")+" " + " "+rs.getString("name")+ " "+rs.getString("email")+ 
                        " "+rs.getString("mobile")+ " "+rs.getString("CG_Mark")+ " "+rs.getString("TOC_Mark")+ 
                        " "+rs.getString("DBMS_Mark")+ " "+rs.getString("Python_Mark")+ " "+rs.getString("Java_Mark"));
                
                
            }
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
