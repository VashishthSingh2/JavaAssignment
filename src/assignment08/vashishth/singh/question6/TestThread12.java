package assignment08.vashishth.singh.question6;

public class TestThread12 {
	public static void main(String args[]){  
		Account account=new Account();

		Thread1 thread1=new Thread1(account,"Raj");
		Thread2 thread2=new Thread2(account,"Simran");
		
		thread1.start();
		thread2.start();
	}
}
