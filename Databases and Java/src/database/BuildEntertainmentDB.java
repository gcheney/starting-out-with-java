package database;
import java.sql.*;

/**
  This program shows how to create a new database   *
  using Java DB.                                    *
*/
 
public class BuildEntertainmentDB
{
   public static void main(String[] args) throws Exception
   {
      final String DB_URL = "jdbc:derby:EntertainmentDB;create=true";
            
      try {    
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
            
         // Create a Statement object.
         Statement stmt = conn.createStatement();
            
         String sql ="CREATE TABLE DVD ("    +
                 "Title CHAR(25), "   +
                 "Minutes INTEGER, " +
                 "Price DOUBLE)";
         
         // Create the Dvd table.
         System.out.println("Creating the Dvd table...");
         stmt.execute(sql);
         
         sql = "DROP TABLE DVD";
         System.out.println("Deleting the DVD Table...");
         stmt.execute(sql);
         
         // Close the resources.
         stmt.close();     
         conn.close();
         
         //Finsihed
         System.out.println("Finsihed");       
      }
      catch(SQLException e) {
         System.out.println("ERROR: " + e.getMessage());
      }
      finally {
    	  //Exit
    	  System.out.println("Exiting..."); 
    	  System.exit(0);
      }
      
   } 
   
}
