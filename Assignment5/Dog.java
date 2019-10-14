package Dog;

import Boardable.Boardable;
import Pet.Pet;

public class Dog extends Pet implements Boardable{
	private String size;
	int Startmonth;
	int Startday;
	int Startyear;
	int Endmonth;
	int Endday;
	int Endyear;
	
	Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}
	
	public String toString() {
		return "Cat: "+'\n'+ super.toString() +'\n'+ "Size: "+ this.getSize();
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
		Dog d = new Dog("Spot","Susan","White","Medium");
		d.sexid = SPAYED;
		System.out.println(d);
		d.setBoardEnd(10, 1, 2019);
		d.setBoardStart(9, 20, 2019);
		System.out.println(d.boarding(9, 22, 2019));
	}

}
