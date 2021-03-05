package assignment5.vashishth.singh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question5 {
	public List<String> readMovieData(String filename){
		List<String> list=new ArrayList<String>();
		File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment5\\vashishth\\singh\\"+filename); 
		Scanner myReader=null;
		try {
			myReader = new Scanner(maindir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			Object line = myReader.nextLine();
			list.add(line.toString());
		}
		return list;
	}
	public static void main(String[] args){ 
		Scanner sc=new Scanner(System.in);
		Question5 question5=new Question5();
		System.out.println("Enter File Name To Be Read: ");
		String fileName=sc.nextLine();
		List<String> list=new ArrayList<String>();
		list=question5.readMovieData(fileName);
		for(String element:list)
			System.out.println(element);
	}
}
