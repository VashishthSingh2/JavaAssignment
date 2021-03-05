package assignment08.vashishth.singh.question4;

public class Thread2 extends Thread{
	CustomerService customerService=new CustomerService();
	public void run(){ 
		customerService.service("Thread2");
	}
}

