package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();

	public Movie create(Movie movie);

	public Movie findOne(String movieId);

	public void delete(Movie movie);

	public Movie update(Movie movie);
}
