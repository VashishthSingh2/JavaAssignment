// 2. Write a program to check whether the input alphabet is a vowel or not.
package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question2 {
	static boolean checkAlpha(char alph) {
		boolean flag=false;
		if(Character.isUpperCase(alph)) {
			alph=Character.toLowerCase(alph);
		}
		if(alph=='a' || alph=='e' || alph=='i'|| alph=='o'|| alph=='u') {
			flag=true;
		}
		return flag;
	}
	public static void main(String []rags) {
		char alphabet;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Alphabet: ");
		// In case if u enter more than a char i.e. A string , first letter will be taken.
		alphabet=sc.nextLine().charAt(0);
		sc.close();
		System.out.println(checkAlpha(alphabet));
	}
}
