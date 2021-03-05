package assignment08.vashishth.singh.question2;

import java.io.File;
import java.io.IOException;

public class Thread1 extends Thread{
	public void run(){  
		boolean result1,result2,result3;  
		File file1 = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment08\\vashishth\\singh\\question2\\F1\\f11.txt");
		File file2 = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment08\\vashishth\\singh\\question2\\F1\\f12.txt");
		File file3 = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment08\\vashishth\\singh\\question2\\F1\\f13.txt");
		
		try{  
			result1 = file1.createNewFile();  
			result2 = file2.createNewFile(); 
			result3 = file3.createNewFile(); 
			if(result1)
				System.out.println("f11.txt created "+file1.getCanonicalPath());  
			if(result2)
				System.out.println("f12.txt created "+file2.getCanonicalPath()); 
			if(result3)
				System.out.println("f13.txt created "+file3.getCanonicalPath());
		}catch (IOException e){ e.printStackTrace();}    
	}  
}
