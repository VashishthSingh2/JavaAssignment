package assignment3.vashishth.singh;

import java.util.Scanner;

public class BookManager {
	public static void createBooks(Book[] books,int n) {
		Book book=new Book();
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<n;i++) {
			System.out.println("\nEnter Book Title: ");
			book.setBookTitle(sc.nextLine());
			System.out.println("\nEnter Book Price: ");
			book.setBookPrice(sc.nextDouble());
			sc.nextLine();
			System.out.println("\nEnter Book Author: ");
			book.setBookAuthor(sc.nextLine());
			System.out.println("\nEnter Book Publication: ");
			book.setBookPublication(sc.nextLine());
			
			books[i]=book;
		}
	}
	public static void showBooks(Book books[],int n) {
		System.out.println("\nBook Title\tPrice\tAuthor\tPublication");
		for(int i=0;i<n;i++) {
			System.out.println(books[i].getBookTitle()+"\t"+books[i].getBookPrice()+"\t"+books[i].getBookAuthor()+"\t"+books[i].getBookPublication());
		}
	}
	public static void main(String []args) {
		Book books[]=new Book[50];
		int n;
		System.out.println("\nEnter The Number Of Book Info You Want To Store: ");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		createBooks(books,n);
		showBooks(books,n);
	}
}
