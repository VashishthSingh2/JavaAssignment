package assignmnet2_vashishth_singh;

import java.util.Scanner;

public class Question5 {
	public static String findAndReplace(String input,String source,String replace) {
		String finalString="";
		String wordList[] = input.split(" ");
		for (int i = 0; i < wordList.length; i++) { 
			if (replace.equals(wordList[i])) 
				finalString+=source+" ";
			else
				finalString+=wordList[i]+" ";
	    } 
		return finalString;
	}
	public static void main(String []args) {
		String input,source,replace;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The String: ");
		input=sc.nextLine();
		System.out.println("\nEnter The String To Be Replaced: ");
		replace=sc.nextLine();
		System.out.println("\nEnter The Source String: ");
		source=sc.nextLine();
		System.out.println(findAndReplace(input,source,replace).trim());
		
	}
}
