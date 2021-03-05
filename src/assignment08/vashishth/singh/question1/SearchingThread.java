package assignment08.vashishth.singh.question1;

public class SearchingThread extends Thread{
	public void run(){  
		int ar[]= {1,2,3,4,5,6,7,8,9,10},i;
		System.out.println("Searching In Array:");
		for(i=0;i<ar.length;i++) {
			if(ar[i]==3) {
				System.out.println("Searching Thread.... Element 3 Found");  
				break;
			}
		}
		System.out.println("Element 3 Found At "+i);
	}  
}