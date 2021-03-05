package assignmnet2_vashishth_singh;

import java.util.Scanner;

public class Question7 {
	public static String swap(String input, int a, int b) {  
        char[] str =input.toCharArray();  
        char ch;  
        ch = str[a];  
        str[a] = str[b];  
        str[b] = ch;  
        return String.valueOf(str);  
    }  
	static void printPermutation(String input,int start,int end) {
        if (start == end-1)  
            System.out.println(input);  
        else{  
            for (int i = start; i < end; i++){  
            	input = swap(input,start,i);   
            	printPermutation(input,start+1,end);  
                input = swap(input,start,i);  
            }  
        } 
	}
	public static void main(String []args) {
		String input;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The String: ");
		input=sc.nextLine();
		printPermutation(input,0,input.length());
	}
}
