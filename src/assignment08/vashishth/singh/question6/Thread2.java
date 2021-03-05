package assignment08.vashishth.singh.question6;

import java.util.Scanner;

public class Thread2 extends Thread{
	Account account;
	String name;
	public Thread2(Account ac,String n){
		account=ac;
		name=n;
	}
	public void run(){  
		int bal = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println(name+ " Enter The Amount To Withdraw:");
		bal=sc.nextInt();
		if(account.isSufficientBalance(bal)) {
			System.out.println(name);
			account.withdrawAmount(bal);
		}
	}  
}