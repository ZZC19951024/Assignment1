package Assignment;

public abstract class Employee {

	private String Name;
	private int paymentPerHour;
	
	public Employee(String Name, int paymentPerHour) {}
	
	public abstract int calculateSalary();
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public int getPaymentPerHour() {
		return paymentPerHour;
	}
	
	public void setPaymentPerHour(int paymentPerHour) {
		this.paymentPerHour = paymentPerHour;
	}
}

class Contractor extends Employee{
	
	private int workingHours;
	public Contractor(String Name, int paymentPerHour, int workingHours) {
		super(Name, paymentPerHour);
		this.workingHours = workingHours;
	}

	public int calculateSalary() {
		return workingHours * getPaymentPerHour();
	}
	
}

class FullTime extends Employee{

	public FullTime(String Name, int paymentPerHour) {
		super(Name, paymentPerHour);
	}

	public int calculateSalary() {
		return getPaymentPerHour() * 8;
	}
	
}
