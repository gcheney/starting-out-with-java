package challenges;

public class RetailItem {
	private String description;
	private int units;
	private double price;
	
	public RetailItem(String d, int u, double p){
		description = d;
		units = u;
		price = p;
	}
	
	public RetailItem(RetailItem item){
		description = item.getDescription();
		units = item.getUnits();
		price  = item.getPrice();
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getUnits(){
		return units;
	}
	
	public double getPrice(){
		return price;
	}
}
