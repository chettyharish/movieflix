package com.movie.app.service;

import java.util.List;

import com.movie.app.entity.Movie;

public interface MovieService {
	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void remove(String movieId);
}
