package Assignemnt6;

import java.util.Arrays;

public class Assignment6 {
//Question 2
/*ArrayList internally uses a dynamic array to store the elements.
 *  Manipulation with ArrayList is slow because it internally uses an array. 
 *  If any element is removed from the array, all the bits are shifted in memory.
 *  An ArrayList class can act as a list only because it implements List only.
 *  ArrayList is better for storing and accessing data.*/

/*LinkedList internally uses a doubly linked list to store the elements.
 * Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, 
 * so no bit shifting is required in memory.
 * LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
 * LinkedList is better for manipulating data.
 */
 
public static void main(String arg[]) {
	String s = "anagram";
	String t = "nagaram";
	int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
	System.out.println(uniqueOccurrences(arr));
}
	
public static boolean isAnagram(String s, String t) {
	char[] char1 = s.toCharArray();
	char[] char2 = t.toCharArray();
	Arrays.sort(char1);
	Arrays.sort(char2);
	String s1 = new String(char1);
	String s2 = new String(char2);
	if(s1.equals(s2))
		return true;
	else return false;
}

public static boolean uniqueOccurrences(int[] arr) {
	int[] countarr = new int[arr.length];
	for(int i = 0; i < arr.length; i++) {
		int count = 0;
		for(int j = 0; j < arr.length; j++) {
			if(arr[i] == arr[j])
				count++;
		}
		countarr[i] = count;
	}
	System.out.println(Arrays.toString(countarr));
	for(int i = 0; i < countarr.length; i++) {
		for(int j = 0; j < countarr.length; j++) {
			if(countarr[i] != countarr[j] && i != j)
				return true;
		}
	}
	return false;
}


	
}
