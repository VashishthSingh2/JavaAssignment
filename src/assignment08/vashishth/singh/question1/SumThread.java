package assignment08.vashishth.singh.question1;

public class SumThread extends Thread{
	public void run(){  
		int ar[]= {1,2,3,4,5,6,7,8,9,10},sum=0;
		System.out.println("Performing Sum Of Array Element:");
		for(int i=0;i<ar.length;i++) {
			sum+=ar[i];
		}
		System.out.println("Sum = "+sum);  
	}  
}
