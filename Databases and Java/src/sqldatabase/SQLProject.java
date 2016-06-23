package sqldatabase;

import java.sql.*;

public class SQLProject {
	
	public static void main (String[] args) {
		
		final String DB_URL = "jdbc:derby:PersonDB;create=true";
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL); //Connect to database
			
			// Create a Statement object.
	        Statement stmt = conn.createStatement();
	        
	        stmt.execute("CREATE TABLE `people` ("
			+"`id` int(64) NOT NULL AUTO_INCREMENT,"
			+"`name` varchar(255) NOT NULL,"
			+"`address` varchar(255) NOT NULL,"
			+"UNIQUE (`id`),"
			+"FULLTEXT(`name`, `address`))"); //Create the table

	        stmt.execute("INSERT INTO `people` (`name`, `address`) VALUES ('Bob', '123 Fake Street')"); 	//Insert a row
	        stmt.execute("INSERT INTO `people` (`name`, `address`) VALUES ('Roger', '666 Devil Street')");
	        stmt.execute("INSERT INTO `people` (`name`, `address`) VALUES ('John', '325 Red Street')");

	        stmt.execute("DELETE FROM `people` WHERE `id` = '3' LIMIT 1"); //Delete John's row

			ResultSet rs = stmt.executeQuery("SELECT `name` FROM `people` WHERE `id` < 4 ORDER BY `id`"); //Select the rows
			
			while (rs.next() == true) { //Loop through results
				System.out.println(rs.getString("name")); //Print the result
			}

			rs.close(); //Close the result set
			stmt.close();
			conn.close(); //Close the connection
		}
		catch(SQLException ex)  {
           System.out.println("ERROR: " + ex.getMessage());
        }
	}
}
