package Assignment;

public class Sundae extends IceCream {
	
	public String ToppingName;
	public int Toppingprice;//topping price in cent;
	
	Sundae(String name, int price, String ToppingName, int Toppingprice){
		super(name,price);
		super.name = name;
		super.price = price;
		this.ToppingName = ToppingName;
		this.Toppingprice =Toppingprice;
		
	}
	
	public int getCost(){
		int p = super.price + Toppingprice;
		
		return p;
	}
	
	public String getName() {
		return name+"with"+ToppingName;
	}
}
