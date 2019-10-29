package Assignemnt6;

import java.util.ArrayList;

public class HashMap {
	private int key;
	private int value;
	private ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String arg[]) {
		HashMap hashMap = new HashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));           // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		System.out.println(hashMap.get(2));            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found) 
	}
	
	public void put(int key, int value) {
		boolean New = true;
		for(int i = 0; i < map.size(); i++) {
			if(key == map.get(i).get(0)) {
				map.get(i).set(1, value);
				New = false;
			}
		}
		if(New) {
			ArrayList<Integer> element = new ArrayList<Integer>();
			element.add(key);
			element.add(value);
			map.add(element);
		}
	}

	public int get(int key) {
		for(int i = 0; i < map.size(); i++) {
			if(key == map.get(i).get(0))
				return map.get(i).get(1);
		}
		return -1;
	}

	public void remove(int key) {
		for(int i = 0; i < map.size(); i++) {
			if(key == map.get(i).get(0))
				map.remove(i);
		}
	}


}
