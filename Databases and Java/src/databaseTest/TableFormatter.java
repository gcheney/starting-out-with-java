package databaseTest;
import javax.swing.*;
import java.awt.*;

/**
  The TableFormatter class displays a populated JTable.
*/

public class TableFormatter extends JFrame
{

	private static final long serialVersionUID = 1L;
   // Constants for size.
   private final int WIDTH = 400;
   private final int HEIGHT = 200;
   
   /**
      Constructor
   */
   
   public TableFormatter(Object[][] data, Object[] colNames)
   {
      // Specify an action for the close button.
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      // Create a JTable with the results.
      JTable table = new JTable(data, colNames);
      
      // Put the table in a scroll pane.
      JScrollPane scrollPane = new JScrollPane(table);

      // Add the table to the content pane.
      this.add(scrollPane, BorderLayout.CENTER);
      
      // Set the size
      this.setSize(WIDTH, HEIGHT);
   }
   
   public void display() 
   {
	   this.setVisible(true);
   }
   
}