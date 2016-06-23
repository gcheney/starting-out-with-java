package databaseTest;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
    The PlaceOrder class is a simple order entry system.
 */

public class PlaceOrder extends JFrame
{

   private static final long serialVersionUID = 1L;
   
   CustomerPanel customerPanel; // Panel for customers
   CoffeePanel coffeePanel;     // Panel for coffees
   QtyDatePanel qtyDatePanel;   // Panel for quantity and date
   JPanel buttonPanel;          // Panel for buttons

   /**
       Constructor
   */

   public PlaceOrder()
   {
      // Set the window title.
      this.setTitle("Place Order");
      
      // Specify an action for the close button.
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a CustomerPanel object.
      customerPanel = new CustomerPanel();
      
      // Create a CoffeePanel object.
      coffeePanel = new CoffeePanel();
      
      // Create a QtyDatePanel object.
      qtyDatePanel = new QtyDatePanel();
      
      // Build the ButtonPanel object.
      this.buildButtonPanel();
      
      // Create a BorderLayout manager.
      this.setLayout(new BorderLayout());
      
      // Add the panels to the content pane.
      this.add(customerPanel, BorderLayout.WEST);
      this.add(coffeePanel, BorderLayout.CENTER);
      this.add(qtyDatePanel, BorderLayout.EAST);
      this.add(buttonPanel, BorderLayout.SOUTH);
      
      // Pack and display the window.
      this.pack();
      this.setVisible(true);
   }

   /**
       The buildButtonPanel method builds a panel for
       the Submit and Exit buttons.
   */

   public void buildButtonPanel()
   {
      // Create a panel for the buttons.
      buttonPanel = new JPanel();
      
      // Create a Submit button and add an action listener.
      JButton submitButton = new JButton("Submit");
      submitButton.addActionListener(new SubmitButtonListener());
      
      // Create an Exit button.
      JButton exitButton = new JButton("Exit");
      exitButton.addActionListener(new ExitButtonListener());
      
      // Add the buttons to the panel.
      buttonPanel.add(submitButton);
      buttonPanel.add(exitButton);
   }
   
   /**
       Private inner class that handles submit button events
   */
   
   private class SubmitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            // Get the customer name from the CustomerPanel object.
            String customerName = customerPanel.getCustomer();
            
            // Get the coffee description from the CoffeePanel.
            String coffee = coffeePanel.getCoffee();
            
            // Get the quantity from the QtyDatePanel object.
            int qty = qtyDatePanel.getQuantity();
            
            // Get the order date from the QtyDatePanel object.
            String orderDate = qtyDatePanel.getDate();
      
            // Create a CoffeeDBManager object.
            CoffeeDBManager dbManager = new CoffeeDBManager();
            
            // Get the customer number.
            String customerNum = dbManager.getCustomerNum(customerName);
               
            // Get the coffee product number.
            String prodNum = dbManager.getProdNum(coffee);
               
            // Get the coffee price per pound.
            double price = dbManager.getCoffeePrice(prodNum);
   
            // Submit the order.
            if(dbManager.submitOrder(customerNum, prodNum, qty, price, orderDate))
            {
            	// Let the user know the order was placed.
                JOptionPane.showMessageDialog(null, "Order Placed.");
            }
            else 
            {
            	JOptionPane.showMessageDialog(null, "The Order was NOT placed");
            }
            
            // Clear the text fields for quantity and order date.
            qtyDatePanel.clear();
            
         }
         catch (SQLException ex)
         {
            ex.printStackTrace();
            System.exit(0);
         }
         
      }
      
   }

   /**
       Private inner class that handles exit button events
   */
   
   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
      
   }
   
   /**
       main method
   */

   public static void main(String[] args)
   {
      new PlaceOrder();
   }
  
}