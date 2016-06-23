package database;

import java.sql.*;   // Needed for JDBC classes

/**
 * This program creates the CoffeeDB database.
 */
public class CreateCoffeeDB
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:CoffeeDB;create=true";
      
      try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
					 
		// If the DB already exists, drop the tables.
		dropTables(conn);
		
		// Build the Coffee table.
		buildCoffeeTable(conn);
		
		// Build the Customer table.
		buildCustomerTable(conn);
		
		// Build the UnpaidInvoice table.
		buildUnpaidOrderTable(conn);

        // Close the connection.
        conn.close();
      }
      catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
      
      System.exit(0);
      
   }
	
	/**
	 * The dropTables method drops any existing
	 * in case the database already exists.
	 */
	public static void dropTables(Connection conn)
	{
		System.out.println("Checking for existing tables.");
		
		try
		{
			// Get a Statement object.
			Statement stmt  = conn.createStatement();;

			try
			{
				// Drop the UnpaidOrder table.
				stmt.execute("DROP TABLE Unpaidorder");
				System.out.println("UnpaidOrder table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

			try
			{
				// Drop the Customer table.
				stmt.execute("DROP TABLE Customer");
				System.out.println("Customer table dropped.");				
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

			try
			{
				// Drop the Coffee table.
				stmt.execute("DROP TABLE Coffee");
				System.out.println("Coffee table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
		}
  		catch(SQLException e)
		{
  			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The buildCoffeeTable method creates the
	 * Coffee table and adds some rows to it.
	 */
	public static void buildCoffeeTable(Connection conn)
	{
		try
		{
			// Get a Statement object.
			Statement stmt = conn.createStatement();
			String sql;
         
			// Create the table.
			sql = "CREATE TABLE Coffee (Description VARCHAR(25), ProdNum CHAR(10) NOT NULL PRIMARY KEY, Price DOUBLE)";
			stmt.execute(sql);
							 
			// Insert row #1.
			sql = "INSERT INTO Coffee VALUES ('Bolivian Dark', '14-001', 8.95)";
			stmt.execute(sql);

			// Insert row #2.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Brazilian Dark', " +
                      "'15-001', " +
                      "7.95 )");

			// Insert row #3.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Brazilian Medium', " +
                      "'15-002', " +
                      "7.95 )");

			// Insert row #4.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Brazilian Decaf', " +
                      "'15-003', " +
                      "8.55 )" );

			// Insert row #5.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Central American Dark', " +
                      "'16-001', " +
                      "9.95 )");

			// Insert row #6.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Central American Medium', " +
                      "'16-002', " +
                      "9.95 )");

			// Insert row #1.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Sumatra Dark', " +
                      "'17-001', " +
                      "7.95 )");

			// Insert row #7.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Sumatra Decaf', " +
                      "'17-002', " +
                      "8.95 )");

			// Insert row #8.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Sumatra Medium', " +
                      "'17-003', " +
                      "7.95 )");

			// Insert row #9.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Sumatra Organic Dark', " +
                      "'17-004', " +
                      "11.95 )");

			// Insert row #10.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
						    "'Kona Medium', " +
						    "'18-001', " +
						    "18.45 )");

			// Insert row #11.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
						    "'Kona Dark', " +
						    "'18-002', " +
						    "18.45 )");

			// Insert row #12.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'French Roast Dark', " +
                      "'19-001', " +
                      "9.65 )");

			// Insert row #13.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Galapagos Medium', " +
                      "'20-001', " +
                      "6.85 )");

			// Insert row #14.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Guatemalan Dark', " +
                      "'21-001', " +
                      "9.95 )");

			// Insert row #15.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Guatemalan Decaf', " +
                      "'21-002', " +
                      "10.45 )");

			// Insert row #16.
			stmt.execute("INSERT INTO Coffee VALUES ( " +
                      "'Guatemalan Medium', " +
                      "'21-003', " +
                      "9.95 )");
							 
			System.out.println("Coffee table created.");
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
		
	}

	/**
	 * The buildCustomerTable method creates the
	 * Customer table and adds some rows to it.
	 */
	public static void buildCustomerTable(Connection conn)
	{
      try
      {
    	  	// Get a Statement object.
    	  	Statement stmt = conn.createStatement();
         
         	// Create the table.
         	stmt.execute("CREATE TABLE Customer" +
	            "( CustomerNumber CHAR(10) NOT NULL PRIMARY KEY, " +
	            "  Name VARCHAR(25),"    +
	            "  Address VARCHAR(25)," +
	            "  City VARCHAR(12),"    +
	            "  State CHAR(2),"    +
	            "  Zip CHAR(5) )");

         	// Add some rows to the new table.
         	stmt.executeUpdate("INSERT INTO Customer VALUES" +
               "('101', 'Downtown Cafe', '17 N. Main Street'," +
               " 'Asheville', 'NC', '55515')");
         
         	stmt.executeUpdate("INSERT INTO Customer VALUES" +
               "('102', 'Main Street Grocery'," +
					" '110 E. Main Street'," +
               " 'Canton', 'NC', '55555')");

         	stmt.executeUpdate("INSERT INTO Customer VALUES" +
               "('103', 'The Coffee Place', '101 Center Plaza'," +
               " 'Waynesville', 'NC', '55516')");
					
			System.out.println("Customer table created.");
			
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
      
	}

	/**
	 * The buildUnpaidOrderTable method creates
	 * the UnpaidOrder table.
	 */

	public static void buildUnpaidOrderTable(Connection conn)
	{
      try
      {
    	  // Get a Statement object.
          Statement stmt = conn.createStatement();
          String sql;

          // Make an SQL statement to create the table.
          sql = "CREATE TABLE UnpaidOrder " +
 				"( CustomerNumber CHAR(10) NOT NULL REFERENCES Customer(CustomerNumber), "+
 				"  ProdNum CHAR(10) NOT NULL REFERENCES Coffee(ProdNum),"+
 				"  OrderDate CHAR(10),"+
 				"  Quantity DOUBLE,"+
 				"  Cost DOUBLE )";

          // Execute the statement.
          stmt.execute(sql);

          // Add some rows to the new table.
          sql = "INSERT INTO UnpaidOrder VALUES" +
                "('101', '16-001', '3/15/2006', 5, 49.75)";
          stmt.executeUpdate(sql);
 			
 			sql = "INSERT INTO UnpaidOrder VALUES" +
                "('101', '14-001', '3/17/2006', 7, 62.65)";
          stmt.executeUpdate(sql);

          sql = "INSERT INTO UnpaidOrder VALUES" +
                "('102', '18-002', '3/20/2006', 10, 184.50)";
          stmt.executeUpdate(sql);

          sql = "INSERT INTO UnpaidOrder VALUES" +
                "('103', '17-004', '3/21/2006', 3, 35.85)";
          stmt.executeUpdate(sql);

          sql = "INSERT INTO UnpaidOrder VALUES" +
                "('103', '16-002', '3/22/2006', 6, 59.70)";
          stmt.executeUpdate(sql);
				
          System.out.println("UnpaidOrder table created.");
          stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
      
	}
	
}