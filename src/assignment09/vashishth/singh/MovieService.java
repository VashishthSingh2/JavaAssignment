package assignment09.vashishth.singh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MovieService {
	
	// 2
	public List<Movie> populateMovies(File file){
		List<Movie> movieList=new ArrayList<Movie>();
		Scanner myReader=null;
		Movie movie;
		try {
			myReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			movie=new Movie();
			List<String> list;
			Object line = myReader.nextLine();
			String str[]=line.toString().split(",");
			list=new ArrayList<String>();
			for(int i=0;i<str.length;i++) {
				switch(i) {
					case 0:
						movie.setMovieId(Integer.parseInt(str[i]));
						break;
					case 1:
						movie.setMovieName(str[i]);
						break;
					case 2:
						movie.setMovieType(str[i]);
						break;
					case 3:
						movie.setLanguage(str[i]);
						break;
					case 4:
						movie.setReleaseDate(str[i]);
						break;
					case 5:
						movie.setRating(Double.parseDouble(str[i]));
						break;
					case 6:
						movie.setTotalBusinessDone(Double.parseDouble(str[i]));
						break;
				}
				if(i>6) {
					list.add(str[i]);
				}
			}
			movie.setCasting(list);
			movieList.add(movie);
		}
		return(movieList);
	}
	
	// 3
	public Boolean allAllMoviesInDb(List<Movie> movies) {
		boolean bool=false;
		for(Movie movie:movies) {
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass09","root","password");  
				PreparedStatement stmt=con.prepareStatement("insert into movieDataTable(movieId,movieName,movieType,language,relDate,rating,totalBusinessDone,casting) values(?,?,?,?,?,?,?,?)");  
				
				stmt.setInt(1,movie.getMovieId());
				
				stmt.setString(2,movie.getMovieName()); 
				stmt.setString(3,movie.getMovieType());
				stmt.setString(4,movie.getLanguage());
				stmt.setString(5,movie.getReleaseDate());
				
				stmt.setDouble(6,movie.getRating());
				stmt.setDouble(7,movie.getTotalBusinessDone());
				stmt.setString(8,movie.getCasting().toString());
				
				int i=stmt.executeUpdate();  
				con.close();
				stmt.close();
				bool=true;
			}catch(Exception e){ 
				e.printStackTrace();
			}  
		}
		return bool;
	}
	
	// 4
	public void addMovie(Movie movie,List<Movie> movies) {
		movies.add(movie);
	}
	
	// 5
	public void serializeMovies(List<Movie> movies, String fileName) {
		try {
			File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment09\\vashishth\\singh\\"+fileName); 
            FileOutputStream f = new FileOutputStream(maindir);
            ObjectOutputStream o = new ObjectOutputStream(f);
            for(Movie movie: movies) {
            	o.writeObject(movie);
            }
            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } 
	}
	
	// 6
	public List<Movie> deserializeMovie(String fileName){
		List<Movie> list=new ArrayList<Movie>();
		try {
			File maindir = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment09\\vashishth\\singh\\"+fileName); 
            FileInputStream fi = new FileInputStream(maindir);
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Movie cont1 = (Movie) oi.readObject();
            Movie cont2 = (Movie) oi.readObject();
            Movie cont3 = (Movie) oi.readObject();
            Movie cont4 = (Movie) oi.readObject();
            Movie cont5 = (Movie) oi.readObject();
            oi.close();
            fi.close();
            list.add(cont1);
            list.add(cont2);
            list.add(cont3);
            list.add(cont4);
            list.add(cont5);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } 
		catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return(list);
	}
	
	// 7
	public List<Movie> getMoviesRealeasedInYear(int year){
		List<Movie> list=new ArrayList<Movie>();
		String date=null;
		LocalDate localDate = null;
        DateTimeFormatter formatter = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/ass09","root","password");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from movieDataTable;");  
			while(rs.next()) { 
				Movie movie=new Movie();
				//System.out.println("[ Movie Id = "+rs.getInt(1)+"  ,Movie Name = "+rs.getString(2)+"  ,Language = "+rs.getString(3)+"  ,Releasing Date = "+rs.getDate(4)+" ]");  

				movie.setMovieId(rs.getInt(1));
			
				movie.setMovieName(rs.getString(2)); 
				movie.setMovieType(rs.getString(3));
				movie.setLanguage(rs.getString(4));
				movie.setReleaseDate(rs.getString(5));
				//System.out.println(rs.getString(5));
				
				date = rs.getString(5);
		        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        localDate = LocalDate.parse(date, formatter);

				movie.setRating(rs.getDouble(6));
				movie.setTotalBusinessDone(rs.getDouble(7));

				String str=rs.getString(8).toString().substring(1, rs.getString(8).toString().length()-1);
				List<String> strList=new ArrayList<String>(Arrays.asList(str.split(",")));
				movie.setCasting(strList);
				
				if(localDate.getYear()==year)
					list.add(movie);
			}
			con.close();
			stmt.close();
			rs.close();
			
		}catch(Exception e){ 
			 e.printStackTrace();
		} 
		return list;
	}
	
	// 8
	public List<Movie> getMoviesByActor(String ...actorNames){
		List<Movie> movieList=new ArrayList<Movie>();
		Scanner myReader=null;
		Movie movie;
		try {
			myReader = new Scanner(new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment09\\vashishth\\singh\\movieDetails.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			movie=new Movie();
			List<String> list;
			Object line = myReader.nextLine();
			String str[]=line.toString().split(",");
			list=new ArrayList<String>();
			for(int i=0;i<str.length;i++) {
				switch(i) {
					case 0:
						movie.setMovieId(Integer.parseInt(str[i]));
						break;
					case 1:
						movie.setMovieName(str[i]);
						break;
					case 2:
						movie.setMovieType(str[i]);
						break;
					case 3:
						movie.setLanguage(str[i]);
						break;
					case 4:
						movie.setReleaseDate(str[i]);
						break;
					case 5:
						movie.setRating(Double.parseDouble(str[i]));
						break;
					case 6:
						movie.setTotalBusinessDone(Double.parseDouble(str[i]));
						break;
				}
				if(i>6) {
					list.add(str[i]);
				}
			}
			movie.setCasting(list);
			for(String st:actorNames) {
				if(list.contains(st)) {
					movieList.add(movie);
					break;
				}
			}
		}
		return(movieList);
	}
	
	// 9
	public void updateRatings(Movie movie, double rating ,List<Movie> movies) {
		for(int i=0;i<movies.size();i++) {
			if(movies.get(i).getMovieId()==movie.getMovieId()) {
				movies.get(i).setRating(rating);
				break;
			}
		}
	}
	
	//10
	public void updateBusiness(Movie movie, double amount,List<Movie> movies) {
		for(int i=0;i<movies.size();i++) {
			if(movies.get(i).getMovieId()==movie.getMovieId()) {
				movies.get(i).setTotalBusinessDone(amount);
				break;
			}
		}
	}
	
	// 11 
	public Set<Movie> businessDone(double amount){
		List<Movie> movieList=new ArrayList<Movie>();
		Set<Movie> s = new HashSet<Movie>();
		Scanner myReader=null;
		Movie movie;
		try {
			myReader = new Scanner(new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment09\\vashishth\\singh\\movieDetails.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(myReader.hasNext()){ 
			movie=new Movie();
			List<String> list;
			Object line = myReader.nextLine();
			String str[]=line.toString().split(",");
			list=new ArrayList<String>();
			int i;
			for(i=0;i<str.length;i++) {
				switch(i) {
					case 0:
						movie.setMovieId(Integer.parseInt(str[i]));
						break;
					case 1:
						movie.setMovieName(str[i]);
						break;
					case 2:
						movie.setMovieType(str[i]);
						break;
					case 3:
						movie.setLanguage(str[i]);
						break;
					case 4:
						movie.setReleaseDate(str[i]);
						break;
					case 5:
						movie.setRating(Double.parseDouble(str[i]));
						break;
					case 6:
						movie.setTotalBusinessDone(Double.parseDouble(str[i]));
						break;
				}
				if(i>6) {
					list.add(str[i]);
				}
			}
			movie.setCasting(list);
			movieList.add(movie);
		}
		for(Movie m:movieList) {
			if(m.getTotalBusinessDone()>amount) {
				s.add(m);
			}
		}
		return(s);
	}
	public static void main(String[]args) {
		MovieService movieService=new MovieService();
		
		// 2
		File file = new File("C:\\Users\\pc\\Desktop\\CoreJavaWorkSpace\\Ass1_Vashishth_Singh\\src\\assignment09\\vashishth\\singh\\movieDetails.txt"); 
		List<Movie> movieList=new ArrayList<Movie>();
		movieList=movieService.populateMovies(file);
		System.out.println(movieList);
		
		// 3
		System.out.println(movieService.allAllMoviesInDb(movieList));
		
		// 4
		List<String> list=new ArrayList<String>();
		list.add("Ram Charan Teja");
		list.add("Kajal Aggarwal");
		list.add("Chiranjeevi");
		list.add("Dev Gill");
		list.add("Kim Sharma");
		Movie movie=new Movie(6, "Magdheera","South","Telgu","2016-09-29",list,5.67,4545.456);
		movieService.addMovie(movie,movieList);
		System.out.println(movieList);
		
		// 5
		movieService.serializeMovies(movieList,"serData.txt");
		
		// 6
		System.out.println(movieService.deserializeMovie("serData.txt"));
		
		// 7
		System.out.println(movieService.getMoviesRealeasedInYear(2015));
		
		// 8
		System.out.println(movieService.getMoviesByActor("Muni","Chris Hemsworth"));
		
		// 9
		List<String> list1=new ArrayList<String>();
		list1.add("Muni");
		list1.add("Vashishth");
		list1.add("Sunil");
		list1.add("Ramesh");
		Movie movie1=new Movie(1, "Barfi","Bollywood","Hindi","2020-02-20",list1,8.7,230000.45);
		System.out.println(movieList);
		movieService.updateRatings(movie1,6.77,movieList);
		System.out.println(movieList);
		
		//10
		List<String> list2=new ArrayList<String>();
		list2.add("Muni");
		list2.add("Vashishth");
		list2.add("Sunil");
		list2.add("Ramesh");
		Movie movie2=new Movie(1, "Barfi","Bollywood","Hindi","2020-02-20",list2,8.7,230000.45);
		System.out.println(movieList);
		movieService.updateBusiness(movie2,230055.45,movieList);
		System.out.println(movieList);
		
		//11
		List<Movie> sortedList=new ArrayList<Movie>(movieService.businessDone(50000.40));
		Comparator<Movie> cm1=Comparator.comparing(Movie::getTotalBusinessDone);  
		Collections.sort(sortedList,cm1);  
		System.out.println(sortedList);
	}
}
