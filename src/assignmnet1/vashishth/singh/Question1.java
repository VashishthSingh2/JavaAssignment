// 1. Find the maximum of three numbers 

package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question1 {
	static int calMax(int x,int y,int z) {
		return(x>y?x:y)>z?(x>y?x:y):z;
	}
	public static void main(String []rags) {
		int x,y,z;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Three Number: ");
		x=sc.nextInt();
		y=sc.nextInt();
		z=sc.nextInt();
		sc.close();
		System.out.println("Max = "+calMax(x,y,z));
	}
}
