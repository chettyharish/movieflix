package com.movie.app.service;

import java.util.List;


import com.movie.app.entity.Authenticator;

public interface AuthenticatorService {
	public List<Authenticator> findAll();

	public Authenticator findByUserName(String username, String password);

	public Authenticator findOne(String authenticatorId);

	public Authenticator create(Authenticator authenticator);

	public Authenticator update(String authenticatorId, Authenticator authenticator);

	public void remove(String authenticatorId);

}
