/* 8. Electricity board wants to develop program to calculate Electricity Bill. 
    They have two types of connections domestic and commercial, charges for domestic 
    bill are as follows if consumed units are less or equals 100 then Rs.4/units 
    or Rs. 250 whichever is greater
	if consumed units are between 100 to 300 then Rs.4.50/units
	if more than 300 and less than 500 Rs.4.75/units and above 500 Rs.5/units
	
	For commercial connections charges are calculated as follows 
	Consumed units are less or equals 100 then Rs.4.25/units or Rs. 350 whichever is greater.
	if consumed units are between 100 to 300 then Rs.4.75/units.
	if more than 300 and less than 500 Rs.5/units and above 500 Rs.5.25/units calculate 
	electricity bill.
*/
package assignmnet1.vashishth.singh;

import java.util.Scanner;
enum TypeOfUses{DOMESTIC,COMMERCIAL}
public class Question8 {
	public static void calculateElectricityBillFotDomestic(int consumedUnits) {
		double totalBill=0;
		System.out.println("inside Domestic");
		if(consumedUnits<=100) {
			totalBill=consumedUnits*4;
		}else if(consumedUnits>100 && consumedUnits<300) {
			totalBill=consumedUnits*4.50;
		}else if(consumedUnits>300 && consumedUnits<500) {
			totalBill=consumedUnits*4.75;
		}else if(consumedUnits>500){
			totalBill=consumedUnits*5.25;
		}else {
			totalBill=(100*4)+250.0;
		}
		System.out.println("Total Bill= "+totalBill);
	}
	public static void calculateElectricityBillFotCommercial(int consumedUnits) {
		double totalBill=0;
		System.out.println("inside Commercial");
		if(consumedUnits<=100) {
			totalBill=consumedUnits*4.25;
		}else if(consumedUnits>100 && consumedUnits<300) {
			totalBill=consumedUnits*4.75;
		}else if(consumedUnits>300 && consumedUnits<500) {
			totalBill=consumedUnits*5.0;
		}else if(consumedUnits>500){
			totalBill=consumedUnits*5.25;
		}else {
			totalBill=(100*4)+350.0;
		}
		System.out.println("Total Bill= "+totalBill);
	}
	public static void main(String []rags) {
		int consumedUnits,flag;
		TypeOfUses typeOfUses=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The Consumed Units: ");
		consumedUnits=sc.nextInt();
		System.out.println("\nEnter 1 For  DOMESTIC And 2 For COMMERCIAL");
		flag=sc.nextInt();
		sc.close();
		if(flag==1) {
			typeOfUses=TypeOfUses.DOMESTIC;
		}else if(flag==2) {
			typeOfUses=TypeOfUses.COMMERCIAL;
		}
		System.out.println(consumedUnits+" "+flag+"  "+typeOfUses);
		switch(typeOfUses) {
			case DOMESTIC:
				calculateElectricityBillFotDomestic(consumedUnits);
				break;
			case COMMERCIAL:
				calculateElectricityBillFotCommercial(consumedUnits);
				break;
		}
	}
}
