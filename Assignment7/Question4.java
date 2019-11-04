package Assignment7;

import java.util.Random;

public class Question4 {

	
	/*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
    	Random rd = new Random(); 
        for (int i = 0; i < arr.length; i++) 
           arr[i] = rd.nextInt();
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
    	int l = arr.length;
    	adding first = new adding(arr,0,l/4);
    	adding second = new adding(arr,l/4,l/2);
    	adding third = new adding(arr,l/2,l/2+l/4);
    	adding fourth = new adding(arr,l/2+l/4,l);
    	
    	Thread FirstThread = new Thread(first);
    	Thread SecondThread = new Thread(second);
    	Thread ThirdThread = new Thread(third);
    	Thread FourthThread = new Thread(fourth);
    	FirstThread.start();
    	SecondThread.start();
    	ThirdThread.start();
    	FourthThread.start();
    	
    	try {
    		FirstThread.join();
    		SecondThread.join();
    		ThirdThread.join();
    		FourthThread.join();
    		
		} catch (InterruptedException ie) {}
    	
    	long FirstSum = first.getSum();
    	long SecondSum = second.getSum();
    	long ThirdSum = third.getSum();
    	long FourthSum = fourth.getSum();
    	
    	System.out.println("First part sum = "+ FirstSum);
    	System.out.println("Second part sum = "+ SecondSum);
    	System.out.println("Third part sum = "+ ThirdSum);
    	System.out.println("Fourth part sum = "+ FourthSum);
    	
    	return FirstSum + SecondSum + ThirdSum + FourthSum;
    }
    

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}

class adding implements Runnable{
    int start, end; 
    long sum;
    int[] arr;
    public adding(int[] arr,int start, int end){
        this.start = start;
        this.end = end;
        this.arr = arr;
    }
    public void run() {
        sum = add(arr,start,end);
    }
    public long add(int[] arr,int start, int end){
    	long total = 0;
    	for(int i = start; i < end; i++) {
    		total = total + arr[i];
    	}
    	
    	return total;
    }
    public long getSum() {
    	return sum;
    }
        
}