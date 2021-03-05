package nugget2.com.muni;

import java.util.Scanner;

public class Question3 {
	
	static int[] findPrime() {
		int startRange,endRange,flag,elements[]=new int[50],index=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Start And End Range: ");
		startRange=sc.nextInt();
		endRange=sc.nextInt();
		for(int i=startRange;i<=endRange;i++) {
			flag=0;
			for(int k=2;k<=i/2;k++) {
				if(i%k==0) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				elements[index]=i;
				index++;
			}
		}
		return elements;
	}
	public static void main(String []args) {
		for(int element:findPrime()) {
			if(element!=0)
				System.out.println(element);
			else
				break;
		}
	}
}
