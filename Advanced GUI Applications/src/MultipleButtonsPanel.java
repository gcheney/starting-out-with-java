
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MultipleButtonsPanel extends JPanel {

   //Declare GUI Components and variables
   private static final long serialVersionUID = 1L;
   private final JButton btnA;
   private final JButton btnB;
   private final JButton btnC;
   private int countA;
   private int countB;
   private int countC;

   /**
    * Contructor that initializes all buttons 
    * and variables 
    */
   public MultipleButtonsPanel() {
	   
	  btnA = new JButton("Button A");
	  btnB = new JButton("Button B");
	  btnC = new JButton("Button C");
	  
	  initActionListeners();
	  
      this.add(btnA);
      this.add(btnB);
      this.add(btnC);
      
      countA = countB = countC = 0;
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
	     System.out.println("Hey");
	   }

	   if(btn != null) {
		   btnText = btn.getText();
	   }
	   
	   String message = btnText + " was clicked " + count + " times";
	   JOptionPane.showMessageDialog(this, message);
   }

   /**
    * Creates and displays the GUI frame
    */
   private static void createAndShowGui() {
      final MultipleButtonsPanel mainPanel = new MultipleButtonsPanel();
      
      final JFrame frame = new JFrame("The Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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