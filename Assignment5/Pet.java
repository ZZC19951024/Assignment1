package Pet;

public class Pet {
	private String name;
	private String ownerName;
	private String color;
	protected int sexid;
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int SPAYED = 3;
	public static final int NEUTERED = 4;
			
	public Pet (String name, String ownerName, String color) {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	public String getPetName() {
		return name;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getColor() {
		return color;
	}
	void setSex(int sexid) {
		
		this.sexid = sexid;
	}
	public String getSex() {
		if(sexid == MALE) {
			return "MALE";
		}
		if(sexid == FEMALE) {
			return "FEMALE";
		}
		if(sexid == SPAYED) {
			return "SPAYED ";
		}
		if(sexid == NEUTERED) {
			return "NEUTERED";
		}
		return "sex need to be reset";
	}
	public String toString() {
		return this.name+" owned by "+ this.ownerName +'\n'+"Color: "+ this.color +'\n'+"Sex: "+ this.getSex();
	} 
	
	public static void main(String arg[]) {
		Pet p = new Pet("Spot","Mary","Black and White");
		p.sexid = MALE;
		System.out.println(p);
	}
}
