package databaseTest;

import java.sql.*;

import javax.swing.JOptionPane;

/**
   The CoffeeDBManager class performs operations on
   the CoffeeDB database.
*/

public class CoffeeDBManager
{
   // Constant field for database URL.
   private final String DB_URL = "jdbc:derby:CoffeeDB";

   // Field for the database connection
   private Connection conn;

   /**
      Constructor
   */

   public CoffeeDBManager() throws SQLException
   {
      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL);
   }

   /**
       The getCoffeeNames method returns an array
       of Strings containing all the coffee names.
   */

   public String[] getCoffeeNames() throws SQLException
   {
      // Create a Statement object for the query.
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
    		  								ResultSet.CONCUR_READ_ONLY);

      // Execute the query.
      String sql = "SELECT Description FROM Coffee";
      ResultSet result = stmt.executeQuery(sql);

      // Get the number of rows
      result.last();                 // Move to last row
      int numRows = result.getRow(); // Get row number
      result.first();                // Move to first row

      // Create an array for the coffee names.
      String[] listData = new String[numRows];

      // Populate the array with coffee names.
      for (int index = 0; index < numRows; index++)
      {
         // Store the coffee name in the array.
         listData[index] = result.getString(1);

         // Go to the next row in the result set.
         result.next();
      }

      // Close the connection and statement objects.
      conn.close();
      stmt.close();

      // Return the listData array.
      return listData;
   }

   /**
       The getProdNum method returns a specific
       coffee's product number.
		 @param coffeeName The specified coffee.
   */

   public String getProdNum(String coffeeName) throws SQLException
   {
      String prodNum = ""; // Product number

      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL);

      // Create a Statement object for the query.
      Statement stmt = conn.createStatement();

      // Execute the query.
      String sql = "SELECT ProdNum FROM Coffee WHERE Description = '" 
    		  				+ coffeeName + "'";
      
      ResultSet resultSet = stmt.executeQuery(sql);

      // If the result set has a row, go to it
      // and retrieve the product number.
      if (resultSet.next())
         prodNum = resultSet.getString(1);

      // Close the Connection and Statement objects.
      conn.close();
      stmt.close();

      // Return the product number.
      return prodNum;
   }

   /**
       The getCoffeePrice method returns the price
       of a coffee.
		 @param prodNum The specified product number.
   */

   public double getCoffeePrice(String prodNum) throws SQLException
   {
      double price = 0.0;  // Coffee price

      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL);

      // Create a Statement object for the query.
      Statement stmt = conn.createStatement();

      // Execute the query.
      ResultSet resultSet = stmt.executeQuery(
                          "SELECT Price " +
                          "FROM Coffee " +
                          "WHERE ProdNum = '" +
                          prodNum + "'");

      // If the result set has a row, go to it
      // and retrieve the price.
      if (resultSet.next())
         price = resultSet.getDouble(1);

      // Close the connection and statement objects.
      conn.close();
      stmt.close();

      // Return the price.
      return price;
   }

   /**
       The getCustomerNames method returns an array
       of Strings containing all the customer names.
   */

   public String[] getCustomerNames() throws SQLException
   {
      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL);

      // Create a Statement object for the query.
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 							ResultSet.CONCUR_READ_ONLY);

      // Execute the query.
      ResultSet resultSet = stmt.executeQuery("SELECT Name FROM Customer");

      // Get the number of rows
      resultSet.last();                 // Move last row
      int numRows = resultSet.getRow(); // Get row number
      resultSet.first();                // Move to first row

      // Create an array for the customer names.
      String[] listData = new String[numRows];

      // Populate the array with customer names.
      for (int index = 0; index < numRows; index++)
      {
         // Store the customer name in the array.
         listData[index] = resultSet.getString(1);

         // Go to the next row in the result set.
         resultSet.next();
      }

      // Close the connection and statement objects.
      conn.close();
      stmt.close();

      // Return the listData array.
      return listData;
   }

   /**
       The getCustomerNum method returns a specific
       customer's number.
		 @param name The specified customer's name.
   */

   public String getCustomerNum(String name)
                                throws SQLException
   {
      String customerNumber = "";

      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL);

      // Create a Statement object for the query.
      Statement stmt = conn.createStatement();

      // Execute the query.
      ResultSet resultSet =
        stmt.executeQuery("SELECT CustomerNumber " +
                          "FROM Customer " +
                          "WHERE Name = '" + name + "'");

      if (resultSet.next())
         customerNumber = resultSet.getString(1);

      // Close the connection and statement objects.
      conn.close();
      stmt.close();

      // Return the customer number.
      return customerNumber;
   }

   /**
       The submitOrder method submits an order to
       the UnpaidOrder table in the CoffeeDB database.
		 @param custNum The customer number.
		 @param prodNum The product number.
		 @param quantity The quantity ordered.
		 @param price The price.
		 @param orderDate The order date.
		 @return True if order was placed succesfully,
		  false otherwise
   */

   public boolean submitOrder(String custNum, String prodNum, int quantity, 
		   					double price, String orderDate) 
		   							throws SQLException
   {
      // Calculate the cost of the order.
      double cost = quantity * price;
      boolean orderSubmitted;
      
      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL);
      conn.setAutoCommit(false);

      // Create a Statement object for the query.
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
											ResultSet.CONCUR_READ_ONLY);
      try 
      {
    	  //Get Qty ResultSetfrom Inventory
    	  ResultSet resultSet = stmt.executeQuery("SELECT Qty FROM Inventory "
    	  		+ "WHERE ProdNum = '" + prodNum + "'");
    	  
    	  //If there is a result
    	  if(resultSet.next())
    	  {
    		  int currQty = resultSet.getInt(1);	//Current quantity avaliable
    		  
    		  //if currQty to low or request too high, throw exception
	    	  if(currQty <= 0 || quantity > currQty)
	    	  {
	    		  throw new Exception("The inventory is too low");
	    	  }
    	  }

    	  //Update the Inventory
    	  stmt.executeUpdate("UPDATE Inventory SET Qty = Qty - " 
    			  			 + quantity + " WHERE ProdNum = '" + prodNum + "'");
    	  
	      // Add the order to the UnpaidOrders Table
	      stmt.executeUpdate("INSERT INTO UnpaidOrder VALUES('" +
	                         custNum + "', '" +
	                         prodNum + "', '" + orderDate + "', " +
	                         quantity + ", " + cost + ")");
	      conn.commit();
	      orderSubmitted = true;
      }
      catch(Exception ex)
      {
    	  //roll back the changes
    	  conn.rollback();
    	  JOptionPane.showMessageDialog(null, ex.getMessage());;
    	  orderSubmitted = false;
      }
      
      // Close the connection and statement objects.
      conn.close();
      stmt.close();
      
      //return the boolean
      return orderSubmitted;
   }
   
}