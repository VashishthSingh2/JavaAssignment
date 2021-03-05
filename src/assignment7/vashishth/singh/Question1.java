package assignment7.vashishth.singh;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args){ 
		
		Connection con = null;
		PreparedStatement stmt=null;
		File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment7\\vashishth\\singh\\movies.txt"); 
		Scanner myReader=null;
		try {
			myReader = new Scanner(maindir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			Object line = myReader.nextLine();
			String str[]=line.toString().split(",");
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver"); 
 
				con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  
  
				stmt=con.prepareStatement("insert into moviesDataTable values(?,?,?,?)");  
				stmt.setInt(1,Integer.parseInt(str[0]));
				stmt.setString(2,str[1]);
				stmt.setString(3,str[2]);
				stmt.setString(4,str[3]);
 
				stmt.executeUpdate();
				System.out.println("Records Inserted");
				con.close();
				stmt.close();
			}catch(Exception e){ 
				 System.out.println(e+" 4444");
			}  
		}	
	}
}
