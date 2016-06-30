import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TravelExpenses extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Declarethe private fields
	private JLabel lblNumDays;
	private JTextField txtNumDays;
	private JLabel lblAirfare;
	private JTextField txtAirfare;
	private JLabel lblCarRental;
	private JTextField txtCarRental;
	private JLabel lblMiles;
	private JTextField txtMiles;
	private JLabel lblParkingFee;
	private JTextField txtParkingFee;
	private JLabel lblTaxiFee;
	private JTextField txtTaxiFee;
	private JLabel lblConFee;
	private JTextField txtConFee;
	private JLabel lblLodging;
	private JTextField txtLodging;
	private JButton btnCalculate;
	private JPanel panel;
	public Component frame;
	
	//Constructor 
	public TravelExpenses(){
		
		this.setTitle("Travel Expenses");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		this.setSize(width / 2, height / 2);
		this.setLocation(width / 4, height / 4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		
		this.getContentPane().add(panel);
		
		this.setVisible(true);
		
	}//Constructor
	
	//buildPanel() method
	private void buildPanel(){
		panel = new JPanel();
		
		lblNumDays = new JLabel("Number of Days on trip: ");
		panel.add(lblNumDays);
		txtNumDays = new JTextField(10);
		panel.add(txtNumDays);
		
		lblAirfare = new JLabel("Total Airfare Expenses ($): ");
		panel.add(lblAirfare);
		txtAirfare = new JTextField(10);
		panel.add(txtAirfare);
		
		lblCarRental = new JLabel("Total Car Rental Fees ($): ");
		panel.add(lblCarRental);
		txtCarRental = new JTextField(10);
		panel.add(txtCarRental);
		
		lblMiles = new JLabel("Total number of miles driven (in private vehicle): ");
		panel.add(lblMiles);
		txtMiles = new JTextField(10);
		panel.add(txtMiles);
		
		lblParkingFee = new JLabel("Total parking fees encurred ($): ");
		panel.add(lblParkingFee);
		txtParkingFee = new JTextField(10);
		panel.add(txtParkingFee);
		
		lblTaxiFee = new JLabel("Total taxi fees encurred ($): ");
		panel.add(lblTaxiFee);
		txtTaxiFee = new JTextField(10);
		panel.add(txtTaxiFee);
		
		lblConFee = new JLabel("Total conference registration fees ($): ");
		panel.add(lblConFee);
		txtConFee = new JTextField(10);
		panel.add(txtConFee);
		
		lblLodging = new JLabel("Total lodging costs per night($): ");
		panel.add(lblLodging);
		txtLodging = new JTextField(10);
		panel.add(txtLodging);
		
		btnCalculate = new JButton("Calculate Price");
		panel.add(btnCalculate);
		btnCalculate.addActionListener(new Calculator());
	}//buildPanel();
	
	private class Calculator implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int numDays = 0;
			double airfare = 0;
			double carRental = 0;
			double miles = 0;
			double parking = 0;
			double taxi = 0;
			double conference = 0;
			double lodging = 0;
			double meals = 37;
			double parkingExp = 10.00;
			double taxiExp = 20.00;
			double lodgeExp = 95.00;
			double milesExp = 0.27;
			double amountOwed = 0;
			double amountSaved = 0;
			boolean isValid = true; 
			
			try{
				numDays = Integer.parseInt(txtNumDays.getText());
				if(numDays < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The number of days must be a valid whole number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtNumDays.requestFocusInWindow();
				txtNumDays.selectAll();
				isValid = false;
			}
			
			try{
				airfare = Double.parseDouble(txtAirfare.getText());
				if(airfare < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The cost of airfare must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtAirfare.requestFocusInWindow();
				txtAirfare.selectAll();
				isValid = false;
			}
			
			try{
				carRental = Double.parseDouble(txtCarRental.getText());
				if(carRental < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The car rental cost must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtCarRental.requestFocusInWindow();
				txtCarRental.selectAll();
				isValid = false;
			}
			
			try{
				miles = Double.parseDouble(txtMiles.getText());
				if(miles < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The total number of miles driven must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtMiles.requestFocusInWindow();
				txtMiles.selectAll();
				isValid = false;
			}
			
			try{
				parking = Double.parseDouble(txtParkingFee.getText());
				if(parking < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The total amount of parking fees must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtParkingFee.requestFocusInWindow();
				txtParkingFee.selectAll();
				isValid = false;
			}
			
			try{
				taxi = Double.parseDouble(txtTaxiFee.getText());
				if(taxi < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The total amount of taxi fees must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtTaxiFee.requestFocusInWindow();
				txtTaxiFee.selectAll();
				isValid = false;
			}
			
			try{
				conference = Double.parseDouble(txtConFee.getText());
				if(conference < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The total amount of conference fees must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtConFee.requestFocusInWindow();
				txtConFee.selectAll();
				isValid = false;
			}
			
			try{
				lodging = Double.parseDouble(txtLodging.getText());
				if(lodging < 0)
					throw new NumberFormatException();
			} catch(NumberFormatException exepction){
				JOptionPane.showMessageDialog(frame,
					    "The total amount of lodging and hotel fees must be a valid number.",
					    "Invalid Input",
					    JOptionPane.WARNING_MESSAGE);
				txtLodging.requestFocusInWindow();
				txtLodging.selectAll();
				isValid = false;
			}
			
			if(isValid){
				double totalCost = (lodging * numDays) + conference + taxi
						+ parking + carRental + airfare + (miles * milesExp);
			
				double allowableExpenses = ((meals + parkingExp + lodgeExp + taxiExp) * numDays) 
						+ (miles * milesExp);
				
				if(lodging > lodgeExp)
					amountOwed += (lodging - lodgeExp) * numDays;
				else
					amountSaved += (lodgeExp - lodging) * numDays;
				
				if((taxi/numDays) > taxiExp)
					amountOwed += (taxi/numDays - taxiExp) * numDays;
				else
					amountSaved += (taxiExp - taxi/numDays) * numDays;
				
				if((parking/numDays) > parkingExp)
					amountOwed += (parking/numDays - parkingExp) * numDays;
				else
					amountSaved += (parkingExp - parking/numDays) * numDays;
				
				if(amountSaved < 0)
					amountSaved = 0;
				else if(amountOwed < 0)
					amountOwed = 0;
			
				DecimalFormat formatter = new DecimalFormat("#,##0.00");
			
				JOptionPane.showMessageDialog(null, "Total expenses for this trip: $" + formatter.format(totalCost) + "\n"
						+ "Total reimbursement expenses allowed: $" + formatter.format(allowableExpenses) + "\n" 
						+ "Total excess owed to the company: $" + formatter.format(amountOwed) + "\n"
						+ "Total saved by the employee: $" + formatter.format(amountSaved));
			}//isValid();
			
		}//actionPerformed
		
	}//class Calculator

	public static void main(String[] args) {
		
		new TravelExpenses();
		
	}//main()

}// class TravelExpenses
