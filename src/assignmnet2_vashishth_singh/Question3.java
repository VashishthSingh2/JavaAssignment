package assignmnet2_vashishth_singh;

import java.util.Scanner;

public class Question3 {
	static int findPosition(int num,int[] nos) {
		for(int i=0;i<nos.length;i++) {
			if(num==nos[i]) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String []args) {
		int numbers[]= {1,2,3,4,5,6,7,8,9},numToBeSearched;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter A Number To Search: ");
		numToBeSearched=sc.nextInt();
		System.out.println(findPosition(numToBeSearched,numbers));
	}
}
