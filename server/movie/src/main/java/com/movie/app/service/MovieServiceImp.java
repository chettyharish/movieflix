package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Movie;
import com.movie.app.exception.IllegalSortingOrderException;
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
			throw new MovieNotFoundException("Movie not found");
		}
		return existingTemp;
	}

	@Override
	public List<Movie> findAllType(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findAllType(movieId);
	}

	@Override
	public List<Movie> findAllYear(int year) {
		return repository.findAllYear(year);
	}

	@Override
	public String findAllActors(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findAllActors(movieId);
	}

	@Override
	public String findAllDirectors(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findAllDirectors(movieId);
	}

	@Override
	public String findAllWriters(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findAllWriters(movieId);
	}

	@Override
	public String findAllCountry(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findAllCountry(movieId);
	}

	@Override
	public double findMetascore(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findMetascore(movieId);
	}

	@Override
	public double findIMDBRating(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findIMDBRating(movieId);
	}

	@Override
	public double findIMDBVotes(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findIMDBVotes(movieId);
	}

	@Override
	public String findIMDBId(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findIMDBId(movieId);
	}

	@Override
	public List<Movie> findAllGenre(String Genre) {
		return repository.findAllGenre(Genre);
	}

	@Override
	public List<Movie> findByName(String Name) {
		return repository.findByName(Name);
	}

	@Override
	public List<Movie> findCommentList(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findCommentList(movieId);
	}

	@Override
	public List<Movie> findAllRating(String movieId) {
		Movie existingTemp = repository.findOne(movieId);
		if (existingTemp == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.findAllRating(movieId);
	}

	@Override
	public List<Movie> findSortedMovieIMDBRating(String order) {
		if (order.compareToIgnoreCase("asc") != 0 && order.compareToIgnoreCase("desc") != 0)
			throw new IllegalSortingOrderException("Illegal sorting order ");
		return repository.findSortedMovieIMDBRating(order);
	}

	@Override
	public List<Movie> findSortedMovieIMDBVotes(String order) {
		return repository.findSortedMovieIMDBVotes(order);
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
