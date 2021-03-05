package assignment08.vashishth.singh.question1;

public class AverageThread extends Thread{
	public void run(){  
		int ar[]= {1,2,3,4,5,6,7,8,9,10},sum=0;
		System.out.println("Calculating Average Of Array Element:");
		for(int i=0;i<ar.length;i++) {
			sum+=ar[i];
		}
		System.out.println("Average Of Array Elements:");  
		System.out.println("Average = "+(sum/10));  
	}  
}