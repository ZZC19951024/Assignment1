package Assignment;

public class Cookie extends DessertItem {
	
	public String name;
	public double price;//in dozen
	public int numbers;
	
	Cookie(String name, double price, int numbers){
		this.name = name;
		this.price = price;
		this.price = price;
		this.numbers = numbers;
	}
	
	public int getCost() {
		
		double p = Math.round((price/12)*numbers);
		return (int)p;
	}
	
	public String getName() {
		return name;
	}

}
