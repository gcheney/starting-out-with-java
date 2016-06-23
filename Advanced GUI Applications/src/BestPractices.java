import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class BestPractices {
		
	public static void main(String[] args) {

        final String text = "The Window";
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final MyWindow window = new MyWindow(text);
                window.setVisible(true);
            }
        });
        
    }
	
}

class MyWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public MyWindow(String text) {
        super("My Window");

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyWindow.this.setVisible(false);
                MyWindow.this.dispose();
            }
        });

        final JButton btn = new JButton(text);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MyWindow.this, "Button Pressed", 
                					"Hey", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.setLayout(new FlowLayout());
        this.add(btn);
        this.pack();
    }
}
