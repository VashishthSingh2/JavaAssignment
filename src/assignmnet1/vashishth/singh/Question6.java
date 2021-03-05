// 6. Method will accept range value and print all prime numbers from 2 to range on console.
package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question6 {
	void printPrime(int maxVal) {
		int i,k,flag;
		   for(i=2;i<=maxVal;i++){
			   flag=0;
			   for(k=2;k<=i/2;k++) {
				   if(i%k==0) {
					   flag=1;
					   break;
				   }
			   }
			   if(flag==0)
				   System.out.print(i+" ");
		   }
	}
	public static void main(String []rags) {
		int number;
		Question6 question6=new Question6();
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Number: ");
		number=sc.nextInt();
		sc.close();
		question6.printPrime(number);
	}
}
