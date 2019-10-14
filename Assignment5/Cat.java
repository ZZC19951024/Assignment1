package Cat;

import Boardable.Boardable;
import Dog.Dog;
import Pet.Pet;

public class Cat extends Pet implements Boardable{
	
	private String hairLength;
	int Startmonth;
	int Startday;
	int Startyear;
	int Endmonth;
	int Endday;
	int Endyear;
	
	Cat(String name, String ownerName, String color, String hairLength) {
		super(name, ownerName, color);
		this.hairLength = hairLength;
	}
	
	public String getHairLength() {
		return hairLength;
	}
	
	public String toString() {
		return "Cat: "+'\n'+ super.toString() +'\n'+ "Hair: "+ this.getHairLength();
	}


	public void setBoardStart(int month, int day, int year) {
		this.Startmonth = month;
		this.Startday = day;
		this.Startyear = year;
	}
	
	public void setBoardEnd(int month, int day, int year) {
	
		this.Endmonth = month;
		this.Endday = day;
		this.Endyear = year;
	}

	
	boolean boarding(int month, int day, int year) {
		 if(Startyear == Endyear && year == Startyear) {
			  if(Startmonth == Endmonth && month == Startmonth) {
				  if(day >= Startday &&  day <= Endday) 
					  return true;
			  }
			  else if(Startmonth < Endmonth && month == Startmonth) {
				  if(day >= Startday) 
					  return true;
			  }
			  else if(Startmonth < Endmonth && month == Endmonth) {
				  if(day <= Endday) 
					  return true;
			  }
			  else if(Startmonth < month && month< Endmonth  ) 
				  return true;
		 }
		 else if(Startyear < Endyear && year > Startyear && year < Endyear) 
			 return true;
		 
		 else if(Startyear < Endyear && year == Startyear) {
			 if(month == Startmonth) {
				 if(day >= Startday) 
					 return true;
			 }
			 else if(month > Startmonth) 
				 return true;
		 }
		 else if(Startyear < Endyear && year == Endyear) {
			 if(month == Endmonth) {
				 if(day <= Endday) 
					  return true;
			 }
			 else if(month < Endmonth) 
				 return true;
		 }
		return false;
	 }
	
	public static void main(String arg[]) {
		Cat c = new Cat("Tom","Bob","black","short");
		c.sexid = SPAYED;
		System.out.println(c);
		c.setBoardEnd(10, 1, 2019);
		c.setBoardStart(9, 20, 2019);
		System.out.println(c.boarding(9, 22, 2019));
	}


}
