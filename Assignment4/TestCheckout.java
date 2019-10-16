package Assignment;

import java.util.ArrayList;

public class TestCheckout {
	public static void main(String arg[]) {
		Checkout checkout = new Checkout(); 
		checkout.EnterItem(new Candy("Peanut Butter Fudge", 2.25, 399)); 
		checkout.EnterItem(new IceCream("Vanilla Ice Cream", 105)); 
		checkout.EnterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50)); 
		checkout.EnterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399)); 
		System.out.println("\nNumber of items: " + checkout.numberOfItem() + "\n"); 
		System.out.println("\nTotal cost: " + checkout.TotalCost() + "\n"); 
		System.out.println("\nTotal tax: " + checkout.TotalTax() + "\n"); 
		System.out.println("\nCost + Tax: " + (checkout.TotalCost() + checkout.TotalTax()) + "\n"); 
		System.out.println(checkout); 
		checkout.clear();
		
		checkout.EnterItem(new IceCream("Strawberry Ice Cream", 145)); 
		checkout.EnterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50)); 
		checkout.EnterItem(new Candy("Gummy Worms", 1.33, 89)); 
		checkout.EnterItem(new Cookie("Chocolate Chip Cookies", 4, 399)); 
		checkout.EnterItem(new Candy("Salt Water Taffy", 1.5, 209)); 
		checkout.EnterItem(new Candy("Candy Corn", 3.0, 109)); 
		System.out.println("\nNumber of items: " + checkout.numberOfItem() + "\n"); 
		System.out.println("\nTotal cost: " + checkout.TotalCost() + "\n"); 
		System.out.println("\nTotal tax: " + checkout.TotalTax() + "\n"); 
		System.out.println("\nCost + Tax: " + (checkout.TotalCost() + checkout.TotalTax()) + "\n"); 
		System.out.println(checkout); 

		
	}
}

 abstract class DessertItem{
	
	 protected String name;
	
	 DessertItem(){}
	 public String getName() {
		 
		 return getClass().getSimpleName();
	 }
	 
	 public abstract int getCost();
}
 
 class DessertShop {
	 final float tax = 0.015f;
	 public String ShopName;
	 
	 DessertShop (String ShopName){
		 this.ShopName = ShopName;
	 }
		 
	 public String Cent2Dollar(int price) {
		 
		 float p = (float)price/100;
		 return String.valueOf(p);
		 
	 } 
 }
 
 class Checkout{
	 
	 DessertShop Yummy = new DessertShop("Yummy");
	 ArrayList<DessertItem> list = new ArrayList<DessertItem>();
	 Checkout(){}
	 
	 public int numberOfItem() {
		 return list.size();
	 }
	 
	 public void EnterItem(DessertItem d) {
		 list.add(d);
	 }
	 
	 public void clear() {
		 list.clear();
	 }
	 
	 public int TotalCost() {
		 int TotalCost = 0;
		 for(int i = 0; i < list.size(); i++) {
			 TotalCost = TotalCost + list.get(i).getCost();
		 }
		 return TotalCost;
	 }
	 
	 public int TotalTax() {
		 float TotalCost = TotalCost() * Yummy.tax;
		 
		 return (int)Math.round(TotalCost);
	 }
	 
	 public String toString() {
		 String Title = Yummy.ShopName+" Dessert Shop"+'\n'+"-----------------"+'\n';
		 String ItemPrice = "";
		 for(int i = 0; i < list.size(); i++) 
			 
			 ItemPrice = ItemPrice + list.get(i).getName()+"----------->"+Yummy.Cent2Dollar(list.get(i).getCost())+'\n';
		 
		 String money = "Tax = "+Yummy.Cent2Dollar(TotalTax())+'\n'+"Total Cost = "+Yummy.Cent2Dollar(TotalCost()+TotalTax());
		 return Title + ItemPrice + money;
	 }
 }
