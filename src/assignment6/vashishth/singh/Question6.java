package assignment6.vashishth.singh;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question6 {
	public static <T> void genericDisplay (T element) 
    { 
        System.out.println(element.getClass().getName() + 
                           " = " + element); 
    } 
	public static void main(String args[]){  
		
		Movie movie=new Movie("I'm Matture","Hindi","14/12/1995","Muni","Muni",1);
		genericDisplay(movie);
		
		LocalDate date = LocalDate.now();  
		EmployeeBeanClass employeeBeanClass=new EmployeeBeanClass("Muni","SDE",7077,date);
		genericDisplay(employeeBeanClass);
		
		int i=new Integer(5);
		genericDisplay(i);
		
		List<String> list=new ArrayList<String>();
		list.add("Vashishth");
		list.add("Muni");
		list.add("Singh");
		genericDisplay(list);
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "Apple");
		map.put("2", "Orange");
		map.put("3", "Banana");
		genericDisplay(map);
		
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		genericDisplay(set);
		
	}  
}
