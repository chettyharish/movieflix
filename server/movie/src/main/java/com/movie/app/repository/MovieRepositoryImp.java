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
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public List<Movie> findAllType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllType", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Movie> findAllYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllYear", Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	@Override
	public String findAllActors(String movieId) {
		TypedQuery<String> query = em.createNamedQuery("Movie.findActors", String.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public String findAllDirectors(String movieId) {
		TypedQuery<String> query = em.createNamedQuery("Movie.findDirectors", String.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public String findAllWriters(String movieId) {
		TypedQuery<String> query = em.createNamedQuery("Movie.findWriters", String.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public String findAllCountry(String movieId) {
		TypedQuery<String> query = em.createNamedQuery("Movie.findCountry", String.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public double findMetascore(String movieId) {
		TypedQuery<Double> query = em.createNamedQuery("Movie.findMetascore", Double.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public double findIMDBRating(String movieId) {
		TypedQuery<Double> query = em.createNamedQuery("Movie.findIMDBRating", Double.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public double findIMDBVotes(String movieId) {
		TypedQuery<Double> query = em.createNamedQuery("Movie.findIMDBVotes", Double.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public String findIMDBId(String movieId) {
		TypedQuery<String> query = em.createNamedQuery("Movie.findIMDBId", String.class);
		query.setParameter("pId", movieId);
		return query.getResultList().get(0);
	}

	@Override
	public List<Movie> findAllGenre(String Genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllGenre", Movie.class);
		query.setParameter("pGenre", Genre);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByName(String Name) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByName", Movie.class);
		query.setParameter("pTitle", Name);
		return query.getResultList();
	}

	@Override
	public List<Movie> findCommentList(String movieId) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findCommentList", Movie.class);
		query.setParameter("pId", movieId);
		return query.getResultList();
	}

	@Override
	public List<Movie> findAllRating(String movieId) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllRating", Movie.class);
		query.setParameter("pId", movieId);
		return query.getResultList();
	}

	@Override
	public List<Movie> findSortedMovieIMDBRating(String order) {
		TypedQuery<Movie> query;
		if (order.compareToIgnoreCase("asc") == 0) {
			query = em.createNamedQuery("Movie.findSortedMovieIMDBRating", Movie.class);
		} else {
			query = em.createNamedQuery("Movie.findSortedMovieIMDBRatingDESC", Movie.class);
		}
		return query.getResultList();
	}

	@Override
	public List<Movie> findSortedMovieIMDBVotes(String order) {
		TypedQuery<Movie> query;
		if (order.compareToIgnoreCase("asc") == 0) {
			query = em.createNamedQuery("Movie.findSortedMovieIMDBVotes", Movie.class);
		} else {
			query = em.createNamedQuery("Movie.findSortedMovieIMDBVotesDESC", Movie.class);
		}

		return query.getResultList();
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
