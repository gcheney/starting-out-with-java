
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MultipleButtonsFrame extends JFrame {

   //Declare GUI Components and variables
   private static final long serialVersionUID = 1L;
   private final JPanel mainPanel = new JPanel(); 
   private final JButton btnA = new JButton("Button A");
   private final JButton btnB = new JButton("Button B");
   private final JButton btnC = new JButton("Button C");
   private int countA;
   private int countB;
   private int countC;

   /**
    * Contructor that initializes all buttons 
    * and variables 
    */
   public MultipleButtonsFrame(String name) {
	   
	  super(name);	  
	  countA = countB = countC = 0;
	  
	  mainPanel.add(btnA);
	  mainPanel.add(btnB);
	  mainPanel.add(btnC);
	  this.getContentPane().add(mainPanel);
	  
	  initActionListeners();
   }
   
   /**
    * Sets up all ActionListeners and ActionEvents
    * for the JButtons A, B and C
    */
   private void initActionListeners() {
		  
	   btnA.addActionListener(new ActionListener() {
	    	  
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            printMessage(e, ++countA);
	         }
	      });
	      
	      btnB.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 printMessage(e, ++countB);
	         }
	      });
	      
	      btnC.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 printMessage(e, ++countC);
	         }
	      });
   }
   
   /**
    * Shows a message dialog with the ActionEvent information
    * @param event The ActionEvent object
    * @param count The number of times this Object 
    * has been clicked
    */
   private void printMessage(ActionEvent event, int count) {  
	   Object source = event.getSource();
	   JButton btn = null;
	   String btnText = "";

	   if(source instanceof JButton) {
	     btn = (JButton)source;
	   }

	   if(btn != null) {
		   btnText = btn.getText();
	   }
	   
	   String message = btnText + " was clicked " + count + " times";
	   JOptionPane.showMessageDialog(this, message, "A Button Was Clicked", 
			   JOptionPane.INFORMATION_MESSAGE);
   }

   /**
    * Creates and displays the GUI frame
    */
   private static void createAndShowGui() {
      final MultipleButtonsFrame frame = new MultipleButtonsFrame("The Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   /**
    * Runs the program
    * @param args
    */
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
    	 @Override
         public void run() {
            createAndShowGui();
         }
      });
   }
}