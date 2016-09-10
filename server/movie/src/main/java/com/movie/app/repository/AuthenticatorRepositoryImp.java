package com.movie.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movie.app.entity.Authenticator;

@Repository
public class AuthenticatorRepositoryImp implements AuthenticatorRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Authenticator> findAll() {
		TypedQuery<Authenticator> query = em.createNamedQuery("Authenticator.findAll", Authenticator.class);
		return query.getResultList();
	}

	@Override
	public Authenticator findOne(String authenticatorId) {
		return em.find(Authenticator.class, authenticatorId);
	}

	@Override
	public Authenticator create(Authenticator authenticator) {
		em.persist(authenticator);
		return authenticator;
	}

	@Override
	public Authenticator update(Authenticator authenticator) {
		return em.merge(authenticator);
	}

	@Override
	public void delete(Authenticator authenticator) {
		em.remove(authenticator);
	}
}
