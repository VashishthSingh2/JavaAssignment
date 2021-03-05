package assignment6.vashishth.singh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TestEmployeeBeanClass {
	 public static int menu() {
		 System.out.println();
		 System.out.println("1. Display all employee Information.");
		 System.out.println("2. Display all employees who have joined organization before entered date.");
		 System.out.println("3. Display all employees who have completed six months in organization.");
		 System.out.println("4. Display employee as per joining date (recently joined employees at the Top).");
		 System.out.println("5. Exit");
		 int ch;
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter Your choice: ");
		 ch=sc.nextInt();
		 return(ch);
	 }
	 public static void main(String args[]){  
		 Scanner sc=new Scanner(System.in);
		 Set<EmployeeBeanClass> setOfEmployee=new TreeSet<EmployeeBeanClass>();  
		 LocalDate date = LocalDate.now();  
		 int flag=0;
		 EmployeeBeanClass e1=new EmployeeBeanClass("Muni","SDE",7077,date);
		 EmployeeBeanClass e2=new EmployeeBeanClass("Sanjay","TE",7076,date.minusDays(10));
		 EmployeeBeanClass e3=new EmployeeBeanClass("Sagar","SDLC",7075,date.minusMonths(5));
		 EmployeeBeanClass e4=new EmployeeBeanClass("Ravi","DEVOPS",7074,date.minusYears(2));
		 EmployeeBeanClass e5=new EmployeeBeanClass("Pushparaj","SDE",7073,date.minusWeeks(500));
		 EmployeeBeanClass e6=new EmployeeBeanClass("Kullu","IT",7072,date.minusYears(10));
		 setOfEmployee.add(e1);
		 setOfEmployee.add(e2);
		 setOfEmployee.add(e3);
		 setOfEmployee.add(e4);
		 setOfEmployee.add(e5);
		 setOfEmployee.add(e6);
		 while(true) {
			 switch(menu()) {
			 	case 1:
			 		System.out.println("----------------------------------------------------------------");
			 		for(EmployeeBeanClass emp:setOfEmployee){  
			 		   System.out.println(emp);  
			 		}  
			 		break;
			 	case 2:
			 		System.out.println("Enter The Date: i.e.  2017-01-13 ");
			 		String d;
			 		d=sc.nextLine();
			 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 		LocalDate enteredDate =LocalDate.parse(d, formatter);
			 		for(EmployeeBeanClass emp:setOfEmployee){  
			 			if(emp.getDate().compareTo(enteredDate)<0)
			 				System.out.println(emp);  
				 	}  
				 	break;
			 	case 3:
			 		for(EmployeeBeanClass emp:setOfEmployee){  
			 			if(emp.getDate().compareTo(LocalDate.now().minusMonths(6))<0)
			 				System.out.println(emp);  
				 	}  
				 	break;
			 	case 4:
			 		List<EmployeeBeanClass> listOfEmployee=new ArrayList<EmployeeBeanClass>();
			 		for(EmployeeBeanClass emp:setOfEmployee){  
			 			listOfEmployee.add(emp);
				 	}
			 		Comparator<EmployeeBeanClass> cm=Comparator.comparing(EmployeeBeanClass::getDate);
			 		Collections.sort(listOfEmployee,cm);  
			 		for(EmployeeBeanClass employeeBeanClass:listOfEmployee) {
			 			System.out.println(employeeBeanClass);
			 		}
			 		break;
			 	case 5:
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
