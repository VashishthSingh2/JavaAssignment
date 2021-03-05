package assignment6.vashishth.singh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question4 {
	public static int menu() {
		System.out.println("1. Enter The String: ");
		System.out.println("2. Get Map");
		System.out.println("3. Exit");
		System.out.println("Enter Your Choice: ");
		int ch;
		Scanner sc=new Scanner(System.in);
		ch=sc.nextInt();
		return(ch);
	}
	public static int countUniqueCharacters(String input) {
	    boolean[] isItThere = new boolean[Character.MAX_VALUE];
	    for (int i = 0; i < input.length(); i++) {
	        isItThere[input.charAt(i)] = true;
	    }
	    int count = 0;
	    for (int i = 0; i < isItThere.length; i++) {
	        if (isItThere[i] == true){
	            count++;
	        }
	    }
	    return count;
	}
	
	public static void main(String args[]){  
		int flag=0,count;
		String str=null;
		Boolean bool;
		Scanner sc=new Scanner(System.in);
		Map<Integer,String> map=new HashMap<Integer,String>();
		while(true) {
			switch(menu()) {
				case 1:
					bool=false;
					System.out.println("Enter The String: ");
					str=sc.nextLine();
					if(map.isEmpty()) {
						count=countUniqueCharacters(str);
						System.out.println("String Not Found In Map:: Number Of Unique Char: "+count);
						map.put(count, str);
					}else {
						for(Map.Entry<Integer, String> entry:map.entrySet()) {
							if(entry.getValue().equals(str)) {
								System.out.println("String Found In Map:: Number Of Unique Char: "+entry.getKey());
								bool=true;
								break;
							}
						}
						if(!bool) {
							count=countUniqueCharacters(str);
							System.out.println("String Not Found In Map:: Number Of Unique Char: "+count);
							map.put(count, str);
						}
					}
					break;
				case 2:
					System.out.println(map);
					break;
				case 3:
					flag=1;
					break;
				default:
					System.out.println("Invalid Choice:");
			}
			if(flag==1) {
				break;
			}
		}
	}  
}
