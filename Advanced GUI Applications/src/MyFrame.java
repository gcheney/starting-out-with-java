import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//we have a class which will display a window
//and listen for the button clicks
public class MyFrame extends JFrame implements ActionListener {
	
   private static final long serialVersionUID = 1L;
   private JButton button = new JButton();
   private int count = 0;
  
   public MyFrame()
   {
       this.setSize(200,200);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(button);

       //we are telling button that it has a listener
       //for its ActionEvent, marking the JButton as the trigger
       //and this object as the listener
       button.addActionListener(this);
       this.add(button);
   }

   //this is our response
   //when the listener is notified of an event
   //being fired, it will invoke this method
   public void actionPerformed(ActionEvent e){
       button.setText("I have been clicked " + (++count) + " times");
   }
   
   public static void main(String[] args) {
       MyFrame frame = new MyFrame();
       frame.setVisible(true);
   }
}

