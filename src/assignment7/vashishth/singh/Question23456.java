package assignment7.vashishth.singh;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Question23456 {
	public static int menu() {
		int ch = 0;
		System.out.println("------------------ Menu Start ---------------------");
		System.out.println("1. Get All Movie List");
		System.out.println("2. Add New Movie");
		System.out.println("3. Delete Movie");
		System.out.println("4. Update Movie");
		System.out.println("5. Display Movies By Language");
		System.out.println("6. Display Movies By Shows For Today");
		System.out.println("7. book Shows");
		System.out.println("8. Get All Bookings");
		System.out.println("9. Exit");
		System.out.println("------------------ Menu Start ----------------------");
		System.out.println("Enter The Choice: ");
		
		Scanner sc=new Scanner(System.in);
		ch=sc.nextInt();
		return ch;
	}
	public static void getAllMovieList() {
		System.out.println("------------------  All Movie List ----------------------");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from moviesDataTable");  
			while(rs.next())  
				System.out.println("[ Movie Id = "+rs.getInt(1)+"  ,Movie Name = "+rs.getString(2)+"  ,Language = "+rs.getString(3)+"  ,Releasing Date = "+rs.getDate(4)+" ]");  

			con.close();
			stmt.close();
			rs.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	
	public static void addNewMovie() {  
		System.out.println("------------------ Add New Movie ----------------------");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			PreparedStatement stmt=con.prepareStatement("insert into moviesDataTable(movieName,language,relDate) values(?,?,?)");  
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Movie Name: ");
			String movieName=sc.nextLine();
			System.out.println("Enter Movie Language: ");
			String movieLanguage=sc.nextLine();
			System.out.println("Enter Movie Releasing Date: i.e. yyyy-MM-dd Format Only");
			String movieRelDate=sc.nextLine();
			
			stmt.setString(1,movieName);
			stmt.setString(2,movieLanguage);  
			stmt.setString(3,movieRelDate);  
			
			int i=stmt.executeUpdate();  
			System.out.println(i+" Movie Added:");
			
			con.close();
			stmt.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	
	public static void deleteMovie() {
		System.out.println("------------------ Delete Movie ----------------------");
		getAllMovieList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			PreparedStatement stmt=con.prepareStatement("delete from moviesDataTable where id=?");  
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The Movie Id To Be Deleted:"); 
			int movieId=sc.nextInt();
			stmt.setInt(1,movieId);
			
			int i=stmt.executeUpdate();
			if(i!=0) {
				System.out.println(i+" Movie Deleted:"); 
			}else {
				System.out.println("Record With This Id Not Found: Deletion Not Possible:");
			}	
			con.close();
			stmt.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
		
	}
	public static int updateMenu() {
		int ch;
		System.out.println("1. Update Movie Name:");
		System.out.println("2. Update Movie Language:");
		System.out.println("3. Update Movie Releasing Date:");
		System.out.println("4. Update Movie Name,Language & Releasing Date:");
		System.out.println("Enter The Choice: ");
		Scanner sc=new Scanner(System.in);
		ch=sc.nextInt();
		return(ch);
	}
	public static void updateMovie() {
		System.out.println("------------------ Update Movie ----------------------");
		getAllMovieList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			PreparedStatement stmt=con.prepareStatement("select * from moviesDataTable where id=?");  
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The Movie Id To Be Updated:"); 
			int movieId=sc.nextInt();
			stmt.setInt(1,movieId);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {  
				
				stmt=con.prepareStatement("update moviesDataTable set movieName=?, language=?, relDate=? where id=?");
				stmt.setString(1,rs.getString(2));
				stmt.setString(2,rs.getString(3));  
				stmt.setString(3,rs.getString(4)); 
				stmt.setInt(4,movieId);
				
				int ch=updateMenu();
				if(ch==1 || ch==4) {
					sc.nextLine();
					System.out.println("Enter Movie Name: ");
					String movieName=sc.nextLine();
					stmt.setString(1,movieName);
				}
				if(ch==2 || ch==4) {
					if(ch!=4)
						sc.nextLine();
					System.out.println("Enter Movie Language: ");
					String movieLanguage=sc.nextLine();
					stmt.setString(2,movieLanguage);  
				}
				if(ch==3 || ch==4) {
					if(ch!=4)
						sc.nextLine();
					System.out.println("Enter Movie Releasing Date: i.e. yyyy-MM-dd Format Only");
					String movieRelDate=sc.nextLine();
					stmt.setString(3,movieRelDate); 
				}

				int ii=stmt.executeUpdate();  
				if(ii!=0) {
					System.out.println("Movie Data Updated Successfully:");
				}else {
					System.out.println("Could Not Update Movie Data: Internal Server Error: Try Again Latter");
				}
			}else {
				System.out.println("Movie With Id Does't Exist In DB: Updation Not Possible");
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		} 
	}
	public static void bookShows() {
		System.out.println("------------------ Bookings Show----------------------");
		getAllMovieList();
		System.out.println("Enter Movie Id Only To Book:");
		Scanner sc=new Scanner(System.in);
		int movieId=sc.nextInt();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			Statement stmt1=con.createStatement();  
			ResultSet rs=stmt1.executeQuery("select * from moviesDataTable where id="+movieId);
			
			if(rs.next()) {
				PreparedStatement stmt=con.prepareStatement("insert into bookings(name,address,movieId) values(?,?,?)");  
				sc.nextLine();
				System.out.println("Enter Your Name: ");
				String name=sc.nextLine();
				System.out.println("Enter Your Address: ");
				String address=sc.nextLine();
				
				stmt.setString(1,name);
				stmt.setString(2,address);  
				stmt.setInt(3,movieId);  
				
				int i=stmt.executeUpdate();  
				if(i!=0)
					System.out.println(i+" Show Booked:");
				else
					System.out.println("Internal Server Error, Show Couldn't Bokk:");
				stmt.close();
			}else {
				System.out.println("Movie With This Id Doesn't Exist:");
			}
			con.close();
			stmt1.close();
			rs.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	public static void getMovieById(int id) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			PreparedStatement stmt=con.prepareStatement("select * from moviesDataTable where id=?");  
			stmt.setInt(1,id);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				System.out.println("\t\tMOVIE DETAILS: [ Movie Name = "+rs.getString(2)+"  ,Movie Language = "+rs.getString(3)+"  ,Releasing Date = "+rs.getString(4)+" ]"); 
			}else {
				System.out.println("Record With This Id Not Found: Deletion Not Possible:");
			}	
			con.close();
			stmt.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	public static void getAllBookings() {
		System.out.println("------------------ All Bookings ----------------------");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from bookings");  
			while(rs.next()) { 
				String name=rs.getString(1);
				String address=rs.getString(2);
				int id=rs.getInt(3);
				System.out.println("[ Name = "+name+"  ,Address = "+address+"  ,Movie Id = "+id);  
				getMovieById(id);
			}
			con.close();
			stmt.close();
			rs.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	public static void displayMoviesByLanguage() {
		System.out.println("------------------ Displaying Movies By Language ----------------------");
		System.out.println("Enter The Language Name: ");
		Scanner sc=new Scanner(System.in);
		String language=sc.nextLine();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			PreparedStatement stmt=con.prepareStatement("select * from moviesDataTable where language=?");  
			stmt.setString(1,language);
			ResultSet rs=stmt.executeQuery(); 
			while(rs.next())  
				System.out.println("[ Movie Id = "+rs.getInt(1)+"  ,Movie Name = "+rs.getString(2)+"  ,Language = "+rs.getString(3)+"  ,Releasing Date = "+rs.getDate(4)+" ]");  

			con.close();
			stmt.close();
			rs.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	public static void displayMoviesByShowsForToday() {
		System.out.println("------------------ Displaying Movies By Shows For Today ----------------------");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass7","root","password");  

			PreparedStatement stmt=con.prepareStatement("select * from moviesDataTable where relDate=?");  
			stmt.setString(1,LocalDate.now().toString());
			ResultSet rs=stmt.executeQuery(); 
			while(rs.next())  
				System.out.println("[ Movie Id = "+rs.getInt(1)+"  ,Movie Name = "+rs.getString(2)+"  ,Language = "+rs.getString(3)+"  ,Releasing Date = "+rs.getDate(4)+" ]");  

			con.close();
			stmt.close();
			rs.close();
		}catch(Exception e){ 
			 e.printStackTrace();
		}  
	}
	public static void main(String[] args){ 
		
		int breakInfiniteLoop=0;
		while(true) {
			switch(menu()) {
				case 1:
					getAllMovieList();
					break;
				case 2:
					addNewMovie();
					break;    
				case 3:
					deleteMovie();
					break;
				case 4:
					updateMovie();
					break;
				case 5:
					displayMoviesByLanguage();
					break;
				case 6:
					displayMoviesByShowsForToday();
					break;
				case 7:
					bookShows();
					break;
				case 8:
					getAllBookings();
					break;
				case 9:
					breakInfiniteLoop=1;
					break;
				default:
					System.out.println("Invalid Choice: Enter The Choice Again:");
			}
			if(breakInfiniteLoop==1) {
				break;
			}
		}
		System.out.println("Program Ended:");
	}
}
