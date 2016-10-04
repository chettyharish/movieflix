package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Comment;
import com.movie.app.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();

	public Movie create(Movie movie);


	public Movie findOne(String movieId);

	public void delete(Movie movie);

	public Movie update(Movie movie);

	public String findAllActors(String movieId);

	public String findAllDirectors(String movieId);

	public String findAllWriters(String movieId);

	public String findAllCountry(String movieId);

	public double findMetascore(String movieId);

	public double findIMDBRating(String movieId);

	public double findIMDBVotes(String movieId);

	public String findIMDBId(String movieId);

	public List<Movie> findAllType(String type);

	public List<Movie> findAllYear(int year);

	public List<Movie> findAllGenre(String Genre);

	public List<Movie> findByName(String Name);

	public List<Movie> findCommentList(String movieId);

	public List<Movie> findAllRating(String movieId);

	public List<Movie> findSortedMovieIMDBRating(String order);

	public List<Movie> findSortedMovieIMDBVotes(String order);

}
