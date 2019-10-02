package Assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private int credits;
	private int[] studentIds = new int[100];
	private int count = 0;

	Course(int courseId){
		this.courseId = courseId;
	}

	Course(int courseId, int professorId){
		this.courseId = courseId;
		this.professorId = professorId;
	}
	
	Course(int courseId, int professorId, int credit){
		this.courseId = courseId;
		this.professorId = professorId;
		this.credits = credit;
	}
	
	public int getCourseId() {
		return courseId;
	} 
	
	public void setCourseId(int courseId) {
		if(courseId >= 0)
			this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		if(courseName.length() >= 10 && courseName.length() <= 50)
			this.courseName = courseName;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		if(maxCapacity > 10 && maxCapacity < 100)
			this.maxCapacity = maxCapacity;
	}
	
	public int getProfessorId(){
		return professorId;
	}
	
	public void setProfessorId(int professorId) {
		if(professorId == 000000 && professorId >= 100000 && professorId <= 99999)
			this.professorId = professorId;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setCredits(int credits) {
		if(credits > 0 && credits < 10)
			this.credits = credits;
	}
	public int[] getStudentIds() {
		return studentIds;
	}
	
	public void registerStudent(int studentId) {
		count++;		
		studentIds[count-1] = studentId;
	}
	
	public void removeDuplicates(int[] studentIds) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < studentIds.length; i++) {
			if(!list.contains(studentIds[i]) && studentIds[i] != 0)
				list.add(studentIds[i]);
		}
		//System.out.println(list);
		this.studentIds = list.stream().mapToInt(Integer::intValue).toArray();
		//System.out.println(Arrays.toString(studentIds));
	}
	
	public int groupsOfStudents(int[] studentIds) {
		int c = 0;
		for(int i = 0; i < studentIds.length; i++) {
			for(int j = i+1; j < studentIds.length; j++) {
				if(studentIds[i] != 0 && studentIds[j] != 0) {
				if((studentIds[i] + studentIds[j])%2 == 0)
					c++;
				}
			}
		}
		return c;
	}
	
	public String countAndSay(int n) {
		if (n <= 0)
			return null;
		String result = "1";
		int i = 1;
		while (i < n) {
			StringBuilder s = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					s.append(count);
					s.append(result.charAt(j - 1));
					count = 1;
				}
			}
	 
			s.append(count);
			s.append(result.charAt(result.length() - 1));
			result = s.toString();
			i++;
		}
	 
		return result;
}
	
	public void ReverseString(String string) {
		String[] str = string.split(" ");
		String[] reversed = new String[string.length()];
		int high = string.length();
		for(int i = 0; i < str.length; i++) {
			reversed[high-1] = str[i];
			high--;
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < reversed.length; i++) {
			if(reversed[i] != null)list.add(reversed[i]);
		}
		reversed = list.toArray(new String[list.size()]);
		String newString = Arrays.toString(reversed);
        newString = newString.substring(1, newString.length()-1).replace(",", " ");    
		System.out.println(newString);
	}
	
	public int[] spiralOrder(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;
		int colum = matrix[0].length;
		int top = 0;
		int bot = colum - 1;
		int left = 0;
		int right = row - 1;
		int direction = 0;
		while(top <= bot && left <= right) {
			if(direction == 0) {
				for(int i = left; i <= right; i++) {
					list.add(matrix[top][i]);
				}
				top++;
				direction = 1;
			}
			else if(direction == 1) {
				for(int i = top; i <= bot; i++) {
					list.add(matrix[i][right]);
				}
				right--;
				direction = 2;
			}
			else if(direction == 2) {
				for(int i = right; i >= left; i--) {
					list.add(matrix[bot][i]);
				}
				bot--;
				direction = 3;
			}
			else if(direction == 3) {
				for(int i = bot; i >= top; i--) {
					list.add(matrix[i][left]);
				}
				left++;
				direction = 4;
			}
			
		}
		System.out.println(list);
		int[] arr = new int[list.size()];
		for(int i =0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	public String ZigZag(String string, int row) {
		if (row > string.length() || row <= 1) {
            return string;
        }
        
        char[] zigZagChars = new char[string.length()];
        int count = 0;
        
        int interval = 2 * row - 2;
        
        for (int i = 0; i < row; i++) {
            int step = interval - 2 * i;
            for (int j = i; j < string.length(); j += interval) {
                zigZagChars[count] = string.charAt(j);
                count++;
                if (step > 0 && step < interval && j + step < string.length()) {
                    zigZagChars[count] = string.charAt(j + step);
                    count++;
                }                
            }            
        }
        
        return new String(zigZagChars);
    }

	
	//Explain Encapsulation with an example. (Write at least 30-40 words).
	//For example, the payment system for a supermarket needs the support of Encapsulation. All prices of items must be Encapsulation
	// so that employees and customers cannot change the price for item. Only the manager can do that if necessary. That means 
	// all people from other class cannot modify the value. This is the fundamental needs for all payment system.
	
	
	//What is the difference between Encapsulation and Abstraction
    //Abstraction is an OOP concept that focuses only on relevant data of an object. 
	// It hides the background details and emphasizes the essential data points for reducing the complexity and increase efficiency
	//Encapsulation is a method of making a complex system more comfortable to handle for end users.
	//he user need not worry about internal details and complexities of the system
	//Abstraction helps you to partition the program into many independent notions
	//Encapsulated Code is quite flexible and easy to change with new requirements.
	
	
	public static void main(String[] args) {
		Course c = new Course(1234);
		c.registerStudent(1);
		c.registerStudent(2);
		c.registerStudent(3);
		c.registerStudent(3);
		c.registerStudent(3);
		c.registerStudent(3);
		c.registerStudent(4);
		c.registerStudent(5);
		c.registerStudent(5);
		//System.out.println(Arrays.toString(c.studentIds));
		//c.removeDuplicates(c.studentIds);
		//System.out.println(c.countAndSay(0));
		//System.out.println(Arrays.toString(c.studentIds));
		//String s = "You are Beautiful";
		//c.ReverseString(s);
		//int[][] matrix = {{1, 2, 3},{ 4, 5, 6 },{ 7, 8, 9 }};
		//System.out.println(Arrays.toString(c.spiralOrder(matrix)));
		System.out.println(c.ZigZag("PAYPALISHIRING",3));
		//System.out.println(Arrays.toString(c.removeDuplicates(c.studentIds)));
	}
}


