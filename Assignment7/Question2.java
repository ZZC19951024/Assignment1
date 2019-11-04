package Assignment7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class Question2 {
	public static String str = "";
	
	private static void readFromStream(FileInputStream fis) throws IOException {
		
		while (true) {
			int x = fis.read();
			if (x == -1)
				break;
			char c = (char) x;
			str = str + c;
		}
		fis.close();
	}
	
	public static void main(String arg[]) throws Exception{
		 System.out.println(decodeString("3[a]2[bc]"));
		 System.out.println(decodeString("3[a2[c]]"));
		 System.out.println(decodeString("2[abc]3[cd]ef"));
		 
		 
		 File file = new File("\\Users\\12067\\Desktop\\Test.txt");
		 FileInputStream fis = new FileInputStream(file);
		 readFromStream(fis);
		 System.out.print(decodeString(str));
			
		 File Writefile = new File("\\Users\\12067\\Desktop\\result.txt");
		 FileOutputStream fos = new FileOutputStream(Writefile);
		 String data = decodeString(str);
		 fos.write(data.getBytes());
		 fos.close();
		 
	  }
	
	
	public static String decodeString(String s){
    	Stack<Character> StringStack = new Stack<Character>();
    	Stack<Integer> IntegerStack = new Stack<Integer>();
    	String temp = "";
    	String result = "";
    	for(int i = 0; i < s.length(); i++) {
    		int count = 0;
    		if(Character.isDigit(s.charAt(i))) {
    			 while (Character.isDigit(s.charAt(i))) 
                 { 
                     count = count * 10 + s.charAt(i) - '0'; 
                     i++; 
                 } 
                 i--; 
                 IntegerStack.push(count); 
    		}
    		
    		else if(s.charAt(i) == ']') {
    			temp ="";
    			count = 0;
    			if (!IntegerStack.isEmpty()) 
                { 
                    count = IntegerStack.peek(); 
                    IntegerStack.pop(); 
                } 
                while (!StringStack.isEmpty() && StringStack.peek()!='[' ) 
                { 
                    temp = StringStack.peek() + temp; 
                    StringStack.pop(); 
                } 
                if (!StringStack.empty() && StringStack.peek() == '[') 
                    StringStack.pop(); 
                for (int j = 0; j < count; j++) 
                    result = result + temp; 
                for (int j = 0; j < result.length(); j++) 
                    StringStack.push(result.charAt(j)); 
       
                result = ""; 
    		}
    		
    		else if(s.charAt(i) == '[') {
    			if(Character.isDigit(s.charAt(i-1))) {
    				StringStack.push(s.charAt(i));
    			}
    			else {
    				StringStack.push(s.charAt(i));
    				IntegerStack.push(1);
    			}
    		}
    		
    		else
    			StringStack.push(s.charAt(i));
    }
    	while (!StringStack.isEmpty()) {
    		result = StringStack.peek() + result; 
    		StringStack.pop(); 
    	}
   
        return result; 
  }

}
