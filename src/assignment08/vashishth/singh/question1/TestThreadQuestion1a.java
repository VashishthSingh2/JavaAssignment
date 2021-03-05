package assignment08.vashishth.singh.question1;

public class TestThreadQuestion1a {
	public static void main(String args[]){  
		SumThread st=new SumThread();
		AverageThread at=new AverageThread();
		SortingThread sot=new SortingThread();
		SearchingThread srt=new SearchingThread();
		
		st.start();
		at.start();
		sot.start();
		srt.start();
	}  
}
