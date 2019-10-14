package Cat;

import Boardable.Boardable;
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

	public void setBoardStart(int month, int day, int year) {
		if(month < 1 || month > 12 || day < 1 || day > 31 || year<1000 || year > 9999)
			return;
		this.Startmonth = month;
		this.Startday = day;
		this.Startyear = year;
	}

	
	public void setBoardEnd(int month, int day, int year) {
		if(month < 1 || month > 12 || day < 1 || day > 31 || year<1000 || year > 9999)
			return;
		this.Endmonth = month;
		this.Endday = day;
		this.Endyear = year;
	}

	
	public boolean boarding(int month, int day, int year) {
		if(year < Startyear || year > Endday)
			return false;
		else if(year == Startyear){
			if(month < Startmonth || month > Endmonth)
				return false;
			else if(month == Startmonth) {
				if(day < Startday || day > Endday)
					return false;
				else return true;
			}
			else if(month == Endmonth) {
				if(day < Startday || day > Endday)
					return false;
				else return true;
			}
			else return true;
		}
		else if(year == Endyear) {
			if(month < Startmonth || month > Endmonth)
				return false;
			else if(month == Startmonth) {
				if(day < Startday || day > Endday)
					return false;
				else return true;
			}
			else if(month == Endmonth) {
				if(day < Startday || day > Endday)
					return false;
				else return true;
			}
			else return true;
		}
		return true;
	}

}
