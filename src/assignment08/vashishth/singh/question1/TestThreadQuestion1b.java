package assignment08.vashishth.singh.question1;

public class TestThreadQuestion1b {
	public static void main(String args[]){  
		SumThread st=new SumThread();
		AverageThread at=new AverageThread();
		SortingThread sot=new SortingThread();
		SearchingThread srt=new SearchingThread();
		
		st.start();
		try{  
			st.join();  
		}catch(Exception e){System.out.println(e);} 
		
		at.start();
		try{  
			at.join();  
		}catch(Exception e){System.out.println(e);} 
		
		sot.start();
		try{  
			sot.join();  
		}catch(Exception e){System.out.println(e);} 
		
		srt.start();
		try{  
			srt.join();  
		}catch(Exception e){System.out.println(e);} 
	}  
}
