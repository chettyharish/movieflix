package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Authenticator;
import com.movie.app.exception.AuthenticatorExistsException;
import com.movie.app.exception.AuthenticatorNotFoundException;
import com.movie.app.repository.AuthenticatorRepository;

@Service
public class AuthenticatorServiceImp implements AuthenticatorService {
	@Autowired
	private AuthenticatorRepository repository;

	@Override
	public List<Authenticator> findAll() {
		return repository.findAll();
	}

	@Override
	public Authenticator findByUserName(String username, String password) {
		Authenticator existingAuthenticator = repository.findByUserName(username, password);

		if (existingAuthenticator == null) {
			throw new AuthenticatorNotFoundException("Authenticator not found");
		}
		return existingAuthenticator;
	}
	
	@Override
	public Authenticator findOne(String authenticatorId) {
		Authenticator existingAuthenticator = repository.findOne(authenticatorId);

		if (existingAuthenticator == null) {
			throw new AuthenticatorNotFoundException("Authenticator not found");
		}
		return existingAuthenticator;
	}

	@Transactional
	@Override
	public Authenticator create(Authenticator authenticator) {
		/* Allowing duplicates */
		return repository.create(authenticator);
	}

	@Transactional
	@Override
	public Authenticator update(String authenticatorId, Authenticator authenticator) {
		Authenticator existingAuthenticator = repository.findOne(authenticatorId);
		if (existingAuthenticator == null) {
			throw new AuthenticatorExistsException("User already exists");
		}
		return repository.update(authenticator);
	}

	@Transactional
	@Override
	public void remove(String authenticatorId) {
		Authenticator existingAuthenticator = repository.findOne(authenticatorId);
		if (existingAuthenticator == null) {
			throw new AuthenticatorNotFoundException("User not found");
		}
		repository.delete(existingAuthenticator);

	}


}
