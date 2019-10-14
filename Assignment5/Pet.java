package Pet;

public class Pet {
	private String name;
	private String ownerName;
	private String color;
	protected int sexid;
	public Pet (String name, String ownerName, String color) {}; 
	
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
		if(sexid < 1 || sexid >4) {
			System.out.println("1 represent MALE, 2 represent FEMAL, 3 represent SPAYED, 4 represent NEUTERED, please reset");
		}
		this.sexid = sexid;
	}
	public String getSex() {
		if(sexid == 1) {
			return "MALE";
		}
		if(sexid == 2) {
			return "FEMALE";
		}
		if(sexid ==3) {
			return "SPAYED ";
		}
		if(sexid == 4) {
			return "NEUTERED";
		}
		else return "sex need to be reset";
	}
	public String toString() {
		return name+" owned by "+ownerName+'\n'+"Color: "+color+'\n'+"Sex: "+getSex();
	} 
}
