/*
9.	Some credit card companies pay back a small portion of the charges a customer makes over a year. 
A particular credit card company's pay back policy is as follows:
1.0.25% for charges up to Rs. 500.
2.0.50% for the next Rs.1000 (that is, the portion between Rs. 500 and Rs. 1500),
3.0.75% for the next Rs.1000 (that is, the portion between Rs. 1500 and Rs. 2500),
4.1.0% for charges above Rs2500.
Thus, a customer who charges Rs. 400 a year receives Rs.1.00,
which is 0.25 x 1/100 x 400, and one who charges Rs1, 400 a year receives Rs. 5.75, which is 1.25 = 0.25 x 1/100 x 500 
for the first Rs. 500 and 0.50 x 1/100 x 900 = 4.50 for the next Rs. 900. Determine by hand the pay backs amount 
for a customer who charged Rs. 2000 and one who charged Rs. 2600.
Define the program, which accepts a charge amount and computes the corresponding pay back amount.
*/
package assignmnet1.vashishth.singh;
import java.util.Scanner;
public class Question9 {
	public static void computePayBackAmount(int chargeAmount) {
		double payBackAmount=0;
		if(chargeAmount<=500) {
			payBackAmount=0.25* (1.0/100) * chargeAmount;
		}else if(chargeAmount>500 && chargeAmount<=1500) {
			payBackAmount+=( 0.25* (1.0/100) * 500 ) + ( 0.50 * (1.0/100) * (chargeAmount-500) );
		}else if(chargeAmount>1500 && chargeAmount<=2500){
			payBackAmount+=( 0.25* (1.0/100) * 500 ) +( 0.50 * (1.0/100) * 1000 ) + ( 0.75 * (1.0/100) * (chargeAmount-1500) );
		}else if(chargeAmount>2500) {
			payBackAmount+=( 0.25* (1.0/100) * 500 ) +( 0.50 * (1.0/100) * 1000 ) + ( 0.75 * (1.0/100) * 1000 ) + (1.0 * (1.0/100) * (chargeAmount-2500));
		}
		System.out.println("Pay Back Amount = "+payBackAmount);
	}
	public static void main(String []rags) {
		int chargeAmount;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Charge Amount: ");
		chargeAmount=sc.nextInt();
		sc.close();
		computePayBackAmount(chargeAmount);
	}
}
