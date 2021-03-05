package assignment3.vashishth.singh;

import java.util.Scanner;

public class TestRectangle {
	public static void main(String []args) {
		Rectangle r1=new Rectangle();
		Rectangle r2=new Rectangle(10,5);
		Rectangle r3=new Rectangle();
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Length And Breadth For Rectangle 3 : ");
		r3.setLength(sc.nextInt());
		r3.setBreadth(sc.nextInt());
		sc.close();
		
		System.out.println("Rectangle [length="+r1.getLength()+", breadth="+r1.getBreadth()+"]");
		System.out.println("Area = "+r1.getArea());
		
		System.out.println("Rectangle [length="+r2.getLength()+", breadth="+r2.getBreadth()+"]");
		System.out.println("Area = "+r2.getArea());
		
		System.out.println(r3.toString());
		System.out.println("Area = "+r3.getArea());
		
	}
}
