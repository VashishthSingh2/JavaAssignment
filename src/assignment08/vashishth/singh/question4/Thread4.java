package assignment08.vashishth.singh.question4;

public class Thread4 extends Thread{
	CustomerService customerService=new CustomerService();
	public void run(){ 
		customerService.service("Thread4");
	}
}
