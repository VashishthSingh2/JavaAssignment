package assignment08.vashishth.singh.question2;

import java.io.File;
import java.io.IOException;

public class Thread4 extends Thread{
	public void run(){  
		boolean result1;  
		File file1 = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment08\\vashishth\\singh\\question2\\F4\\f41.txt");

		try{  
			result1 = file1.createNewFile();  
			if(result1)
				System.out.println("f11.txt created "+file1.getCanonicalPath());  
		}catch (IOException e){ e.printStackTrace();}    
	}
}
