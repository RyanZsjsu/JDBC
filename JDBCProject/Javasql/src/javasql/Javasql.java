/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasql;
import java.sql.*;

/**
 *
 * @author ryanzaeni
 */
public class Javasql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            //This is where we load the JDBC driver(Step 1)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("WORKS");
            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Unable to load the driver class");
            return;
        }
        
       try{
            //All DB access is within try/catch block(Step 2)
            //Connect to the database specifying the user, password
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/","root", "password" );
            Statement stmt = conn.createStatement();
            
        }
    }
    
}
