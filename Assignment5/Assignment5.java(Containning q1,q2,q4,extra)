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
//Extra Credits
/* The final out put of this pice of code should be 6. At the begainning, the main function creates a B object called b and create
a list of that object, containning 1 ,2 ,3. Then the main function runs the addAll function of the B object. Due to this statement "addCount += c.size();",
the addcount is 3 now because the size of that list is 3. Then the b.addAll function calls the parent A.addAll function. Inside of A.addAll 
function, the add function, which has been overriden by child b object, executes 3 times, so that makes the addCount adds 3 times.
So the getaddCount will fianlly return 6. And the getI will return 0 due to the i varivalble in the parent A class, and the does not
overriden by the child B class. So the final output is 6 + 0 = 0*/
	
