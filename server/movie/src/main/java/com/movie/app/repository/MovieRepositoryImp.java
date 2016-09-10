package com.movie.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movie.app.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Temp.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}
}
