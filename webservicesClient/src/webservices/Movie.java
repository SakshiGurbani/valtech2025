package webservices;

import java.util.List;

public class Movie {
	
	private int id;
	private String name;
	private String language;
	private String genre;
	private List<String> actor;
	
	public Movie() {}
	
	
	public Movie(int id, String name, String language, String genre, List<String> actor) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.genre = genre;
		this.actor = actor;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<String> getActor() {
		return actor;
	}
	public void setActor(List<String> actor) {
		this.actor = actor;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", language=" + language + ", genre=" + genre + ", actor=" + actor
				+ "]";
	}
	
	

}
