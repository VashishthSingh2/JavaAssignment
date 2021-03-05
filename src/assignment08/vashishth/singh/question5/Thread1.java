package assignment08.vashishth.singh.question5;

public class Thread1 extends Thread{
	BookStack bookStack;
	public Thread1(BookStack b) {
		bookStack=b;
	}
	public void run(){ 
		bookStack.choice();
	}
}