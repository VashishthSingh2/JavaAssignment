package assignment5.vashishth.singh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question4 {
	public int countWords(String filePath){
		int count=0;
		File maindir = new File(filePath); 
		Scanner myReader=null;
		try {
			myReader = new Scanner(maindir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			Object line = myReader.nextLine();
			count+=line.toString().split(" ").length;
			//System.out.println(line);
		}
		return count;
	}
	public static void main(String[] args){ 
		Scanner sc=new Scanner(System.in);
		Question4 question4=new Question4();
		int totalWords=question4.countWords("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment5\\vashishth\\singh\\file1.txt");
		System.out.println(totalWords);
	}
}
