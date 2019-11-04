package Assignment7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Question1 {
	public static String str = "";
	
	public static void main(String[] args) throws Exception {
		File file = new File("\\Users\\12067\\Desktop\\Test.txt");
		FileInputStream fis = new FileInputStream(file);
		readFromStream(fis);
		System.out.print(ReverseString(str));
		
		File Writefile = new File("\\Users\\12067\\Desktop\\result.txt");
		FileOutputStream fos = new FileOutputStream(Writefile);
		String data = ReverseString(str);
		fos.write(data.getBytes());
		fos.close();
	}

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
	
	private static String ReverseString(String s) {
		 String[] temp = s.split(" "); 
	        String result = ""; 
	  
	        for (int i = 0; i < temp.length; i++) { 
	            if (i == temp.length - 1) 
	                result = temp[i] + result; 
	            else
	                result = " " + temp[i] + result; 
	        } 
	        return result; 
	}
}
