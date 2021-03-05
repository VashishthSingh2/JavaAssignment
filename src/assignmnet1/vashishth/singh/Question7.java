/**
 * 7. An old-style movie theater has a simple profit program. Each customer pays $5 
 * per ticket. Every performance costs the theater $20, plus $.50 per attendee. 
 * Develop the program that accepts the number of attendees (of a show) and calculates 
 * how much income the show earns.
 * */
package assignmnet1.vashishth.singh;

import java.util.Scanner;

public class Question7 {
	static float calculateProfit( int numAttendees) {
		int totalCollctedMoney=numAttendees*5;
		float totalcosts=20+(float)(numAttendees*0.50);
		return totalCollctedMoney-totalcosts;
	}
	public static void main(String []rags) {
		int numberOfAttendees;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter The number Of Attendees: ");
		numberOfAttendees=sc.nextInt();
		sc.close();
		System.out.println(calculateProfit(numberOfAttendees));
	}
}
