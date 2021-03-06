package assignment09.vashishth.singh;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable{
	private int movieId;
	private String movieName;
	private String movieType;
	private String language; 
	private String releaseDate; 
	private Double rating;
	private Double totalBusinessDone;
	private List<String> casting;
	
	public Movie() {
		super();
	}
	public Movie(int movieId, String movieName, String movieType, String language, String releaseDate,
			List<String> casting, Double rating, Double totalBusinessDone) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.language = language;
		this.releaseDate = releaseDate;
		this.casting = casting;
		this.rating = rating;
		this.totalBusinessDone = totalBusinessDone;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<String> getCasting() {
		return casting;
	}
	public void setCasting(List<String> casting) {
		this.casting = casting;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getTotalBusinessDone() {
		return totalBusinessDone;
	}
	public void setTotalBusinessDone(Double totalBusinessDone) {
		this.totalBusinessDone = totalBusinessDone;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType + ", language="
				+ language + ", releaseDate=" + releaseDate + ", casting=" + casting + ", rating=" + rating
				+ ", totalBusinessDone=" + totalBusinessDone + "]";
	}

}
