package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Authenticator;

public interface AuthenticatorRepository {
	public List<Authenticator> findAll();

	public Authenticator create(Authenticator authenticator);

	public Authenticator findOne(String authenticatorId);

	public void delete(Authenticator authenticator);

	public Authenticator update(Authenticator authenticator);

	public Authenticator findByUserName(String username, String password);

}
