package assignment4.vashishth.singh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie {
	public static void validate(Scanner myReader) throws CustomException{
		int count=0,movieId=0,flag=0;
		String inValidMoviesIdList="";
		while(myReader.hasNext()){ 
			Object line = myReader.nextLine();
			System.out.println(line);
			count++;
			try {
				movieId=Integer.parseInt(line.toString().substring(0,4));
			}catch(NumberFormatException nfe) {
				flag=1;
				inValidMoviesIdList+="MovieId: "+line.toString().substring(0,4)+" Movie Name: "+line.toString().substring(5)+"\n";
			}
		}
		
		if(flag==1){
			throw new CustomException("\nInValid Movies Id Are\n"+inValidMoviesIdList);
		}
		if(count<9) {
			throw new CustomException("Number Of Movies Are "+count+", Should Be Minimum 10, Add Some More Movies");
		}
	}
	public static void main(String args[]){  
		File fileObj=new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment4\\vashishth\\singh/movie.txt");
		Scanner myReader=null;
		try {
			myReader = new Scanner(fileObj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			validate(myReader);
		}catch(CustomException ce) {
			System.out.println(ce);
		}
	} 
}
