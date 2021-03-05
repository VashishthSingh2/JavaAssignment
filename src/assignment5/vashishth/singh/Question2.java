package assignment5.vashishth.singh;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2 {
	static Map<String,List<String>> map=null;
	static void RecursivePrint(File[] arr,int index,int level){ 
		if(index == arr.length) 
			return; 
		else if(arr[index].isDirectory()){ 
			List<String> list=new ArrayList<String>(); 
			for(File file:arr[index].listFiles()) {
				list.add(file.getName());
			}
			map.put(arr[index].getName(),list);
			
			RecursivePrint(arr[index].listFiles(), 0, level + 1); 
		} 
		RecursivePrint(arr,++index, level); 
	} 
	public void displayFolderContents(String path) {
		File maindir = new File(path); 
        if(maindir.exists() && maindir.isDirectory()){ 
            File arr[] = maindir.listFiles(); 
            RecursivePrint(arr,0,0);  
       } 
	}
	public static void main(String[] args){ 
		Question2 question2=new Question2();
		map=new HashMap<String,List<String>>();
		question2.displayFolderContents("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment5\\vashishth\\singh");
		System.out.println(map);
		System.out.println("Folder With The List Of Files Inside:");
		for (Map.Entry<String,List<String>> entry : map.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
	}
}
