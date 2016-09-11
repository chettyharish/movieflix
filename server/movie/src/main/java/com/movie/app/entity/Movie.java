package com.movie.app.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries({

		@NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m "),
		@NamedQuery(name = "Movie.findOne", query = "SELECT m from Movie m where m.movieId = :pId "),
		@NamedQuery(name = "Movie.findAllType", query = "SELECT m from Movie m where m.type=:pType"),
		@NamedQuery(name = "Movie.findAllYear", query = "SELECT m from Movie m where m.year=:pYear"),
		@NamedQuery(name = "Movie.findActors", query = "SELECT m.actors from Movie m where  m.movieId = :pId"),
		@NamedQuery(name = "Movie.findDirectors", query = "SELECT m.directors from Movie m where  m.movieId = :pId"),
		@NamedQuery(name = "Movie.findWriters", query = "SELECT m.writers from Movie m where  m.movieId = :pId"),
		@NamedQuery(name = "Movie.findCountry", query = "SELECT m.writers from Movie m where  m.movieId = :pId"),

		@NamedQuery(name = "Movie.findAllGenre", query = "SELECT m from Movie m where LOWER(m.genre) LIKE CONCAT('%',LOWER(:pType),'%')"),
		@NamedQuery(name = "Movie.findByName", query = "SELECT m from Movie m where LOWER(m.title) LIKE CONCAT('%',LOWER(:ptitle),'%')"),

		@NamedQuery(name = "Movie.findCommentList", query = "SELECT c from Movie m JOIN Comment c where m.movieId = :pId"),
		@NamedQuery(name = "Movie.findRating", query = "SELECT c.rating from Movie m JOIN Comment c where m.movieId = :pId"),

		@NamedQuery(name = "Movie.findIMDBRating", query = "SELECT m.imdbRating from Movie m where m.movieId = :pId"),
		@NamedQuery(name = "Movie.findIMDBVotes", query = "SELECT m.imdbVotes from Movie m where m.movieId = :pId"),
		@NamedQuery(name = "Movie.findIMDBId", query = "SELECT m.imdbID from Movie m where m.movieId = :pId"),
		@NamedQuery(name = "Movie.findSortedMovieIMDBRating", query = "SELECT m from Movie m ORDER BY m.imdbRating"),
		@NamedQuery(name = "Movie.findSortedMovieIMDBVotes", query = "SELECT m from Movie m ORDER BY m.imdbVotes")

})

public class Movie {
	@Id
	private String movieId;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Year")
	private double year;

	@JsonProperty("Rated")
	private String rated;

	@JsonProperty("Released")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date released;

	@JsonProperty("Runtime")
	private String runTime;

	@JsonProperty("Genre")
	private String genre;

	@JsonProperty("Director")
	private String directors;

	@JsonProperty("Writer")
	private String writers;

	@JsonProperty("Actors")
	private String actors;

	@JsonProperty("Language")
	private String language;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Plot")
	private String plot;

	@JsonProperty("Awards")
	private String awards;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("Metascore")
	private double metaScore;

	@JsonProperty("imdbRating")
	private double imdbRating;

	@JsonProperty("imdbVotes")
	private double imdbVotes;

	@JsonProperty("imdbID")
	private String imdbID;

	@JsonProperty("Type")
	private String type;

	@OneToMany
	private List<Comment> commentList;

	public Movie() {
		movieId = UUID.randomUUID().toString();
	}

	public String getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getYear() {
		return year;
	}

	public void setYear(double year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return directors;
	}

	public void setDirector(String director) {
		this.directors = director;
	}

	public String getWriter() {
		return writers;
	}

	public void setWriter(String writer) {
		this.writers = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(double metaScore) {
		this.metaScore = metaScore;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public double getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(double imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runTime=" + runTime + ", genre=" + genre + ", directors=" + directors + ", writers="
				+ writers + ", actors=" + actors + ", language=" + language + ", country=" + country + ", plot=" + plot
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + ", type=" + type + ", commentList="
				+ commentList + "]";
	}

	
	
}
