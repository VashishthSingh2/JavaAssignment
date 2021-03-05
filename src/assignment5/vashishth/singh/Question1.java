package assignment5.vashishth.singh;

import java.io.File;

public class Question1 {
	static void RecursivePrint(File[] arr,int index,int level){ 
		if(index == arr.length) 
			return; 
		for (int i = 0; i < level; i++) 
			System.out.print("\t"); 
		if(arr[index].isFile()) 
			System.out.println(arr[index].getName()); 
		else if(arr[index].isDirectory()){ 
			System.out.println("[" + arr[index].getName() + "]");  
			RecursivePrint(arr[index].listFiles(), 0, level + 1); 
		} 
		RecursivePrint(arr,++index, level); 
	} 
	public void displayFolderContents(String path) {
		File maindir = new File(path); 
        if(maindir.exists() && maindir.isDirectory()){ 
            File arr[] = maindir.listFiles(); 
            System.out.println("Files from main directory : " + maindir); 
            System.out.println("---------------------------------"); 
            RecursivePrint(arr,0,0);  
       } 
	}
	public static void main(String[] args){ 
		Question1 question1=new Question1();
		question1.displayFolderContents("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment5\\vashishth\\singh");
    }
}
