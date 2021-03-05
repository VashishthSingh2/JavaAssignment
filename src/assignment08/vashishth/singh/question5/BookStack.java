package assignment08.vashishth.singh.question5;

import java.util.Scanner;

public class BookStack {
	int top;
	Book books[];
	public BookStack() {
		top=-1;
		books=new Book[5];
	}
	public synchronized void printStack() {
		if(top==-1) {
			System.out.println("Stack Is Empty...");
		}else {
			for(int i=0;i<=top;i++) {
				System.out.println(books[i]);
			}
		}
	}
	public synchronized void push() {
		Book b=new Book();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id:");
		b.setBookId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter Name:");
		b.setBookName(sc.nextLine());
		if(top==4) {
			System.out.println("OverFlow Condition...");
		}else {
			top++;
			books[top]=b;
		}
	}
	public synchronized void pop() {
		if(top==-1) {
			System.out.println("UnderFlow Condition....");
		}else {
			System.out.println("POPED: "+books[top]);
			top--;
		}
	}
	public synchronized void choice() {
		switch(menu()) {
			case 1:
				push();
				break;
			case 2:
				pop();
				break;
			case 3:
				printStack();
				break;
			default:
				System.out.println("Invalid Choice:");
		}
	}
	public synchronized int  menu() {
		int ch;
		System.out.println("1. Push");
		System.out.println("2. Pop");
		System.out.println("3. Show");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Choice:");
		ch=sc.nextInt();
		return(ch);
	}
}
