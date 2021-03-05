package assignment3.vashishth.singh;

import java.util.Random;

class TestMedicine{
	public static void main(String []args) {
		Medicine medicine=null;
		int flag;
	    Random randNum = new Random();
	    while(true) {
	    	flag=randNum.nextInt(4);
	    	if(flag!=0) 
	    		break;
	    }
	    if(flag==1)
	    	medicine=new Tablet();
	    else if(flag==2)
	    	medicine=new Syrup();
	    else if(flag==3)
	    	medicine=new Ointment();
	    medicine.displayLabel();
	}
}