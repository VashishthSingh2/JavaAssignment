package assignment5.vashishth.singh;

import java.io.File;
import java.util.Scanner;

public class Question3 {
	public Boolean searchFile(String path, String filename) {
		File maindir = new File(path); 
        if(maindir.exists() && maindir.isDirectory()){ 
            File arr[] = maindir.listFiles(); 
            for(File file:arr) {
            	if(file.getName().equals(filename)) {
            		return true;
            	}
            }
       } 
		return false;
	}
	public static void main(String[] args){ 
		Scanner sc=new Scanner(System.in);
		Question3 question3=new Question3();
		System.out.println("Enter File Name To Be Searched: ");
		String fileName=sc.nextLine();
		sc.close();
		Boolean b=question3.searchFile("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment5\\vashishth\\singh",fileName);
		System.out.println(b);
	}
}
