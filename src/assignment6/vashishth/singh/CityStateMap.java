package assignment6.vashishth.singh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CityStateMap {
	public static int menu() {
		System.out.println("1. Get all cities");
		System.out.println("2. Get All states");
		System.out.println("3. Get cities for a state");
		System.out.println("4. Add new city state pair");
		System.out.println("5. Delete all the cities for a given state");
		System.out.println("6. Exit");
		System.out.println("Enter Your Choice: ");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		return(ch);
	}
	public static Set<String> getAllCities(Map<String,String> cityStateMap){
		Set<String> keys = cityStateMap.keySet();
		return(keys);
	}
	public static Collection<String> getAllStates(Map<String,String> cityStateMap){
		Collection<String> values = cityStateMap.values();
		return(values);
	}
	public static List<String> getCitiesForAState(Map<String,String> cityStateMap){
		List<String> citiesListForAState=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The State Name: ");
		String state=sc.nextLine();
		for(Map.Entry<String, String> entry:cityStateMap.entrySet()) {
			if(entry.getValue().equals(state)) {
				citiesListForAState.add(entry.getKey());
			}
		}
		return(citiesListForAState);
	}
	public static void addNewCityStatePair(Map<String,String> cityStateMap){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The City Name: ");
		String city=sc.nextLine();
		System.out.println("Enter The State Name: ");
		String state=sc.nextLine();
		cityStateMap.put(city, state);
	}
	public static void deleteAllCitiesForAGivenState(Map<String,String> cityStateMap){
		List<String> list=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The State Name: ");
		String state=sc.nextLine();
		for(Map.Entry<String, String> entry:cityStateMap.entrySet()) {
			if(entry.getValue().equals(state)) {
				list.add(entry.getKey());
			}
		}
		cityStateMap.keySet().removeAll(list);
	}
	public static void main(String args[]){  
		int i,flag=0;
		Map<String,String> cityStateMap=new HashMap<String,String>();
		File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment6\\vashishth\\singh\\cityStateData.txt"); 
		Scanner myReader=null;
		try {
			myReader = new Scanner(maindir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(myReader.hasNext()){ 
			Object line = myReader.nextLine();
			//System.out.println(line);
			for(i=0;i<line.toString().length();i++) {
				if(line.toString().charAt(i)==' ')
					break;
			}
			String key=line.toString().substring(0,i);
			String value=line.toString().substring(i+1);
			//System.out.println(key+"|"+value);
			cityStateMap.put(key, value);
		}
//		for(Map.Entry<String, String> entry:cityStateMap.entrySet()) {
//			System.out.println(entry.getKey()+"|"+entry.getValue());
//		}
		
		while(true) {
			switch(menu()) {
				case 1:
					System.out.println(getAllCities(cityStateMap));
					break;
				case 2:
					System.out.println(getAllStates(cityStateMap));
					break;
				case 3:
					System.out.println(getCitiesForAState(cityStateMap));
					break;
				case 4:
					addNewCityStatePair(cityStateMap);
					System.out.println(cityStateMap);
					break;
				case 5:
					deleteAllCitiesForAGivenState(cityStateMap);
					System.out.println(cityStateMap);
					break;
				case 6:
					flag=1;
					System.out.println("Program Terminated:");
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
