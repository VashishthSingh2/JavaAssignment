package assignment4.vashishth.singh;

import java.util.Scanner;

public class Stack {
	
	public void validate(Contact Contact[],int stackTop,int flag) throws CustomException,StringIndexOutOfBoundsException,NullPointerException{
		if(stackTop==-1 && flag!=2) {
			throw new CustomException("Stack In Empty: POP Is Not Allowed");
		}
		if(stackTop==4 && flag!=1) {
			throw new CustomException("Stack In Full: PUSH Is Not Allowed");
		}
	}
	public int menu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Pop");
		System.out.println("2. Push");
		System.out.println("3. Show Stack Contact");
		System.out.println("4. Exit");
		System.out.println("Enter Your Choice: ");
		try {
			return Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("Provide An Integer String: "+nfe);
		}
		return 3;
	}
	public enum Operation{ PUSH,POP,EXIT,PRINTSTACK }  
	public static void main(String[]args) {
		Contact contactStack[]=new Contact[5];
		Stack stack=new Stack();
		Operation operation=null;
		int flag,stackTop=-1,breakInfiniteLoop=0;
		
		while(true){
			Contact contact=new Contact();
			flag=stack.menu();
			if(flag==1) {
				operation=Operation.POP;
			}else if(flag==2) {
				operation=Operation.PUSH;
			}else if(flag==3) {
				operation=Operation.PRINTSTACK;
			}else if(flag==4) {
				operation=Operation.EXIT;
			}
			switch(operation) {
				case POP:
					try {
						stack.validate(contactStack,stackTop,flag);
						System.out.println("POPED Element:\n"+contactStack[stackTop]);
						stackTop--;
					}catch(CustomException ce){
				    	System.out.println("Exception occured: "+ce);
				    }catch(NullPointerException ne) {
				    	System.out.println("Exception occured: "+ne);
				    }
					break;
				case PUSH:
					try {
						stack.validate(contactStack,stackTop,flag);
						contact.setAndValidateObject();
						stackTop++;
						contactStack[stackTop]=contact;
						System.out.println("PUSHED Element:\n"+contactStack[stackTop]);
					}catch(CustomException ce){
				    	System.out.println("Exception occured: "+ce);
				    }catch(NullPointerException ne) {
				    	System.out.println("Exception occured: "+ne);
				    }
					break;
				case PRINTSTACK:
					System.out.println("Object Are:");
					for(int i=0;i<=stackTop;i++) {
						System.out.println(contactStack[i].toString());
					}
					break;
				case EXIT:
					breakInfiniteLoop=1;
					break;
				default:
					System.out.println("Invalid Choice");
			}//end f switch
			if(breakInfiniteLoop==1) {
				break;
			}
		}//end if infinite loop
		System.out.println("rest Of the code.....");
	}//end of main function
}
