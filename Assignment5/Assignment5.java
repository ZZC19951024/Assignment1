package Assignment;

public class Assignment5 {
	
	//question1
	/*Final is used to apply restrictions on class, method and variable. 
	Final class can't be inherited, final method can't be overridden and final variable value can't be changed.*/
	/*Finally is used to place important code, it will be executed whether exception is handled or not.*/
	
	//question2
	static void countNumber(int Integer1, int Integer2) throws ZeroException,NumberException{
		if(Integer2 == 0) 
			throw new ZeroException();
		if(Integer2 > Integer1)
			throw new NumberException();
		System.out.println(Integer1/Integer2);
	}
	
	
	public static void main(String arg[]) {
		//question2
		/*try{countNumber(3,1);}
		catch(ZeroException ze){
			System.out.println("the divisor cannot be zero");
		}
		catch(NumberException ne){
			System.out.println("the dividend number should be greater than divisor");
		}*/
		//question4
		int ar[] = {1, 2, 3, 4, 5}; 
        for (int i=0; i<=ar.length; i++) {
        	try {
        		if(i > ar.length-1) throw new IndexOutOfBoundException(i,0,ar.length-1);
        		else System.out.println(ar[i]);
        	}
        	catch (Exception ex) {
                System.out.println(ex);
                return;
        	}
		
        }	
	}
}

class ZeroException extends Exception{}

class NumberException extends Exception{}

//question 4
class IndexOutOfBoundException extends Exception{
	int lowerBound, upperBound, index;
	 IndexOutOfBoundException(int index, int lowerBound, int upperBound) {
		    this.index = index;
		    this.lowerBound = lowerBound;
		    this.upperBound = upperBound;
		  }
	 public String toString() {
		 return "Error Message: Index: " + index + ", but Lower bound: " + this.lowerBound + ", Upper Bound: "+ this.upperBound;
	 }
}
	