package assignment08.vashishth.singh.question2;

public class TestThread1234 {
	public static void main(String[]args) {

		Thread1 thread1=new Thread1();
		Thread2 thread2=new Thread2();
		Thread3 thread3=new Thread3();
		Thread4 thread4=new Thread4();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}
}
