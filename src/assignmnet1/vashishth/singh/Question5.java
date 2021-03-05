// 5. Find the number is prime or not.
package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question5 {
	static boolean isPrimeNumber( int num) {
		boolean flag=true;
		for(int i=2; i<=num/2;i++) {
			if(num%i==0) {
				flag=false;
				break;
			}
		}
		return(flag);
	}
	public static void main(String []rags) {
		int number;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Number: ");
		number=sc.nextInt();
		sc.close();
		System.out.println(isPrimeNumber(number));
	}
}
