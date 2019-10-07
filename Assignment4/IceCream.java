package Assignment;

public class IceCream extends DessertItem{

	public String name;
	protected int price;//in cents
	
	IceCream(String name, int price){
		this.name = name;
		this.price = price;
	}
	public int getCost() {
		return price;
	}
	
	public String getName() {
		return name;
	}
}
