package Assignment;

public abstract class MoodyObject {
	
	MoodyObject(){}
	
	protected abstract String getMoody();
	
	protected abstract void expressFeeling();
	
	public void queryMood() {
			
			System.out.println("I feel "+getMoody()+" today");
		
	}
	
	public static void main(String arg[]) {
		PsychiatristObject p = new PsychiatristObject();
		SadObject  s = new SadObject();
		HappyObject h = new HappyObject();
		
		p.examine(h);
		p.observation(h);
		p.examine(s);
		p.observation(s);
	}
}

class SadObject extends MoodyObject{
	
	SadObject(){}
	
	protected String getMoody() {
		return "sad";
	}

	protected void expressFeeling() {
		System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
	}
	
	public String toString() {
		return "Subject cries a lot";
	}
	
}

class HappyObject extends MoodyObject{
	
	HappyObject(){}
	
	protected String getMoody() {
		return "Happy";
	}

	protected void expressFeeling() {
		System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
		
	}
	
	public String toString() {
		return "Subject laughs a lot";
	}
}

class PsychiatristObject{
	
	PsychiatristObject(){}
	
	public void examine(MoodyObject moodyObject) {
		System.out.println("How are you feeling today?");
		
		moodyObject.queryMood();
		moodyObject.expressFeeling();	
	}
	
	public void observation(MoodyObject moodyObject) {
		System.out.println("Observation: "+moodyObject.toString());
	}
}