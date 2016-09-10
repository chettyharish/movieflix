package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Movie;
import com.movie.app.exception.MovieNotFoundException;
import com.movie.app.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String movieId) {
		Movie existingTemp = repository.findOne(movieId);

		if (existingTemp == null) {
			throw new MovieNotFoundException("Temp not found");
		}
		return existingTemp;
	}

	@Transactional
	@Override
	public Movie create(Movie movie) {
		/* Allowing duplicates */
		return repository.create(movie);
	}

	@Transactional
	@Override
	public Movie update(String movieId, Movie movie) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Temp already exists");
		}
		return repository.update(movie);
	}

	@Transactional
	@Override
	public void remove(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Temp not found");
		}
		repository.delete(existingTemp);

	}
}
