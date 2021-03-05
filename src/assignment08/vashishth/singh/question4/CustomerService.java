package assignment08.vashishth.singh.question4;

public class CustomerService {
	synchronized void service(String str) {
		for(int i=1;i<=3;i++) {
			System.out.println("Servicing....."+i+" "+str);
		}
	}
}
