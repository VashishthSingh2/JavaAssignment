/**
 * 3. Develop a program, that accepts a deposit amount and calculates amount of interest 
 * the deposit amount earns in a year. The bank pays a flat 4% interest for 
 * deposits of up to Rs.1000, a flat 4.5% per year for deposits of up to Rs.5000, 
 * and a flat 5% for deposits of more than Rs.5000.
 * */
package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question3 {
	static double calInterest(int amt) {
		double totalInterest=0;
		if(amt<=1000) {
			totalInterest=(amt*4.0)/100;
		}else if(amt>1000 && amt<=5000) {
			totalInterest=(amt*4.5)/100;
		}else if(amt>5000) {
			totalInterest=(amt*5.0)/100;
		}
		return amt+totalInterest;
	}
	public static void main(String []rags) {
		int amount;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Amount: ");
		amount=sc.nextInt();
		sc.close();
		System.out.println(calInterest(amount));
	}
}
