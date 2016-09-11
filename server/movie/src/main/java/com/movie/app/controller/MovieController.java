package com.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.app.entity.Movie;
import com.movie.app.service.MovieService;

@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
	@Autowired
	private MovieService service;

	/*
	 * MovieWrapper : Used for mapping List of Movies from JSON to List of Movie
	 * Objects
	 */
	public static class MovieWrapper {
		@JsonProperty("movie")
		private List<Movie> movie;

		public List<Movie> getMovies() {
			return movie;
		}

		public void setMovies(List<Movie> movie) {
			this.movie = movie;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findOne(@PathVariable("id") String movieId) {
		return service.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "filter/type/{type}")
	public List<Movie> findAllType(@PathVariable("type") String type) {
		return service.findAllType(type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "filter/year/{year}")
	public List<Movie> findAllYear(@PathVariable("year") int year) {
		return service.findAllYear(year);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/actors")
	public String findAllActors(@PathVariable("id") String movieId) {
		return service.findAllActors(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/directors")
	public String findAllDirectors(@PathVariable("id") String movieId) {
		return service.findAllDirectors(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/writers")
	public String findAllWriters(@PathVariable("id") String movieId) {
		return service.findAllWriters(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/countries")
	public String findAllCountry(@PathVariable("id") String movieId) {
		return service.findAllCountry(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/metaScore")
	public double findMetascore(@PathVariable("id") String movieId) {
		return service.findMetascore(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/imdbRating")
	public double findIMDBRating(@PathVariable("id") String movieId) {
		return service.findIMDBRating(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/imdbvotes")
	public double findIMDBVotes(@PathVariable("id") String movieId) {
		return service.findIMDBVotes(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/imdbId")
	public String findIMDBId(@PathVariable("id") String movieId) {
		return service.findIMDBId(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "filter/genre/{genre}")
	public List<Movie> findAllGenre(@PathVariable("genre") String Genre) {
		return service.findAllGenre(Genre);
	}

	@RequestMapping(method = RequestMethod.GET, value = "filter/name/{name}")
	public List<Movie> findByName(@PathVariable("name") String Name) {
		return service.findByName(Name);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/commentList")
	public List<Movie> findCommentList(@PathVariable("id") String movieId) {
		return service.findCommentList(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/allRating")
	public List<Movie> findAllRating(@PathVariable("id") String movieId) {
		return service.findAllRating(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "sort/imdbRating/{order}")
	public List<Movie> findSortedMovieIMDBRating(@PathVariable("order") String order) {
		return service.findSortedMovieIMDBRating(order);
	}

	@RequestMapping(method = RequestMethod.GET, value = "sort/imdbVotes/{order}")
	public List<Movie> findSortedMovieIMDBVotes(@PathVariable("order") String order) {
		return service.findSortedMovieIMDBVotes(order);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.POST, value = "movielist", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createList(@RequestBody MovieWrapper movieWrapper) {
		System.out.println("Starting");
		System.out.println(movieWrapper == null);
		System.out.println(movieWrapper.getMovies().size());
		for (Movie movie : movieWrapper.getMovies())
			System.out.println(movie.getTitle());
		for (Movie movie : movieWrapper.getMovies())
			service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie) {
		return service.update(movieId, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String movieId) {
		service.remove(movieId);
	}
}
