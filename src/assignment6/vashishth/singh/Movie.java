package assignment6.vashishth.singh;

public class Movie implements Comparable<Movie>{
	private String name;
	private String language;
	private String releaseDate;
	private String director;
	private String  producer;
	private int duration; // duration in hr only i.e. 1,2,3,4 etc
	
	public Movie() {
		super();
	}
	public Movie(String name, String language, String releaseDate, String director, String producer, int duration) {
		super();
		this.name = name;
		this.language = language;
		this.releaseDate = releaseDate;
		this.director = director;
		this.producer = producer;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", language=" + language + ", releaseDate=" + releaseDate + ", director="
				+ director + ", producer=" + producer + ", duration=" + duration + "]";
	}
	@Override
	public int compareTo(Movie o) {
		if(language.compareTo(o.language)==0)  
			return 0;  
		else if(language.compareTo(o.language)>0)  
			return 1;  
		else  
			return -1;  
	}
}
