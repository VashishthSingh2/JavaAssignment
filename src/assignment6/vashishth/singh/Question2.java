package assignment6.vashishth.singh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question2 {
	
	public List<Movie> createMovieList(){
		List<Movie> listOfMovies=new ArrayList<Movie>();  
		listOfMovies.add(new Movie("I'm Matture","Hindi","14/12/1995","Muni","Muni",1));  
		listOfMovies.add(new Movie("Kota Factory","English","20/08/1996","Kishan","Kishan",3));  
		listOfMovies.add(new Movie("Class Of 2017","Chinese","22/09/1975","Sanjay","Sanjay",4));  
		listOfMovies.add(new Movie("Mirjapur","Bangali","14/03/1787","Ravi","Ravi",2));  
		listOfMovies.add(new Movie("Criminal Justice","Nepali","02/11/1965","Arushi","Arushi",5));  
		return(listOfMovies);
	}
	
	//Using Comparable Interface to sort the movies according to their language
	public void sortByLanguage(List<Movie> listOfMovies) {
		Collections.sort(listOfMovies);  
		System.out.println("------------------------------------------sortByLanguage----------------------------------------------");
		for(Movie movie:listOfMovies){  
			System.out.println(movie);  
		} 
	}
	
	//Using Comparator Interface to sort the movies according to their Director
	public void sortByDirector(List<Movie> listOfMovies) {
		Comparator<Movie> cm=Comparator.comparing(Movie::getDirector,Comparator.nullsLast(String::compareTo));  
		Collections.sort(listOfMovies,cm);  
		System.out.println("----------------------------------------sortByDirector------------------------------------------------");
		for(Movie movie:listOfMovies){  
			System.out.println(movie);  
		} 
	}
	public void sortByDuration(List<Movie> movieList) {
		Comparator<Movie> cm=Comparator.comparing(Movie::getDuration,Comparator.nullsLast(Integer::compareTo)); 
		Collections.sort(movieList,cm);  
		System.out.println("---------------------------------------------sortByDuration-------------------------------------------");
		for(Movie movie:movieList){  
			System.out.println(movie);  
		} 
	}
	public void SortByLanguageAndReleaseDate(List<Movie> movieList) {
		Comparator<Movie> cm=Comparator.comparing(Movie::getLanguage).thenComparing(Movie::getReleaseDate);  
		Collections.sort(movieList,cm);  
		System.out.println("----------------------------------------SortByLanguageAndReleaseDate------------------------------------------------");
		for(Movie movie:movieList){  
			System.out.println(movie);  
		} 
	}
	public static void main(String args[]){  
		Question2 question2=new Question2();
		List<Movie> listOfMovies=question2.createMovieList();

		question2.sortByLanguage(listOfMovies);
		question2.sortByDirector(listOfMovies);
		question2.sortByDuration(listOfMovies);
		question2.SortByLanguageAndReleaseDate(listOfMovies);
	}  
}
