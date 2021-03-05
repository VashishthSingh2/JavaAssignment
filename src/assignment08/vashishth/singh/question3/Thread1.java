package assignment08.vashishth.singh.question3;

import java.io.FileWriter;

public class Thread1 extends Thread{
	public void run(){  
		try{    
	        FileWriter fw=new FileWriter("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment08\\vashishth\\singh\\question3\\file1.txt");    
	        fw.write("Writing From Thread 1:");    
	        fw.close();    
	    }catch(Exception e){System.out.println(e);}    
	    System.out.println("Success...From Thread 1");    
	}  
}
