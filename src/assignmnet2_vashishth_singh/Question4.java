package assignmnet2_vashishth_singh;

import java.util.Scanner;

public class Question4 {
	static String  makeReverse(String str) {
		String wordList[] = str.split(" ");
		String finalString="";
		StringBuilder input1 = new StringBuilder();
		for(String inp:wordList) {
			input1.append(inp);
			input1.reverse();
			finalString+=input1+" ";
			input1.setLength(0);
		}
		return(finalString);
	}
	public static void main(String []args) {
		String input;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The String: ");
		input=sc.nextLine();
		System.out.println(makeReverse(input));
	}
}
