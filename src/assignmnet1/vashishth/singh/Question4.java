/*	4.  Develop the program, which accepts the gross pay and produces the amount of 
 * 		tax owed. For a gross pay of $240 or less, the tax is 0%; for over $240 and less than 
 *		$480, the tax rate is 15%; and for any pay over $480, the tax rate is 28%.
 */
package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question4 {
	static double calTax(int gp) {
		double totalTax=0;
		if(gp<=240) {
			totalTax=0;
		}else if(gp>240 && gp<=480) {
			totalTax=(gp*15.0)/100;
		}else if(gp>480) {
			totalTax=(gp*28.0)/100;
		}
		return totalTax;
	}
	public static void main(String []rags) {
		int grossPay;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Gross Pay: ");
		grossPay=sc.nextInt();
		sc.close();
		System.out.println(calTax(grossPay));
	}
}
