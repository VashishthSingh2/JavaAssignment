package assignment08.vashishth.singh.question5;

public class TestStack {
	public static void main(String[]args) {
		BookStack bookStack=new BookStack();
		
		Thread1 t1=new Thread1(bookStack);
		Thread1 t2=new Thread1(bookStack);
		Thread1 t3=new Thread1(bookStack);
		Thread1 t4=new Thread1(bookStack);
		Thread1 t5=new Thread1(bookStack);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
