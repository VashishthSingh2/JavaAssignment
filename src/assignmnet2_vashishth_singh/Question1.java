package assignmnet2_vashishth_singh;

import java.util.Scanner;

public class Question1 {
	public static int check(String sentence,String word) {
		int count=0;
		String wordList[] = sentence.split(" ");
		for (int i = 0; i < wordList.length; i++) { 
			if (word.equals(wordList[i])) 
				count++; 
	    } 
		return count;
	}
	public static void main(String []args) {
		String input,word;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The String: ");
		input=sc.nextLine();
		System.out.println("\nEnter The Word: ");
		word=sc.nextLine();
		System.out.println(check(input,word));
	}
}
