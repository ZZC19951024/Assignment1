package Assignment7;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question3 {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input file name with , seperated");
		String[] s = scanner.nextLine().split(",");
			for(int i = 0; i < s.length; i++) {
				System.out.print(s[i]+"-->");
				try {
					System.out.println(Linecounter(s[i]));
				}
				catch(FileNotFoundException ex){
					System.out.println("The file does not exist please try again");
				}
			}
	}

	private static int Linecounter(String str)throws Exception {
		
		  File f1=new File("\\Users\\12067\\Desktop\\" + str); 
	      int linecount=0;            
	      FileReader fr=new FileReader(f1);  
	      BufferedReader br = new BufferedReader(fr); 
	      if(!f1.exists()) {
	    	  throw new FileNotFoundException();
	      }
	      while(br.readLine()!=null)    
	         linecount++;               
	      fr.close();
	      br.close();
	      return linecount;
	}
}
