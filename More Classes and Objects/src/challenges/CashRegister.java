package challenges;

import java.text.DecimalFormat;

public class CashRegister {
	private RetailItem item;
	private int quantity;
	private final double taxRate = .06;
	
	public CashRegister(RetailItem item, int q){
		this.item = new RetailItem(item);
		quantity = q;
	}
	
	public double getUnitPrice(){
		return item.getPrice();
	}
	
	public double getSubtotal(){
		return quantity*item.getPrice();
	}
	
	public double getSalesTax(){
		double subTotal = getSubtotal();
		
		return subTotal*taxRate;
	}
	
	public double getTotal(){
		double tax = getSalesTax();
		double subtotal = getSubtotal();
		
		return tax + subtotal;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public String toString(){
		DecimalFormat df = new DecimalFormat("##.00");
		
		String str = "SALES RECEIPT\n" 
				+ "Unit Price : $" + df.format(getUnitPrice())
				+ "\nQuantity: " + getQuantity()
				+ "\nSusbtotal: $" + df.format(getSubtotal())
				+ "\nSales Tax: $" + df.format(getSalesTax())
				+ "\nTotal: $" + df.format(getTotal());
		
		return str;
	}
}
