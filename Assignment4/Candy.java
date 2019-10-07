package Assignment;

public class Candy extends DessertItem {
	public String name;
	public double weight;//in ponds
	public double price;//in cents
	
	Candy(String name,double weight, double price){
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public int getCost() {
		double p = Math.round(weight * price);
		return (int)p;
	}
	
	public String getName() {
		return name;
	}
	
}
