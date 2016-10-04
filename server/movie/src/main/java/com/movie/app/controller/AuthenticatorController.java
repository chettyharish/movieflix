package com.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.entity.Authenticator;
import com.movie.app.service.AuthenticatorService;

@RestController
@RequestMapping(value = "authenticators", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class AuthenticatorController {
	@Autowired
	private AuthenticatorService service;

	@RequestMapping(method = RequestMethod.GET)
	public Authenticator findByUserName(@RequestParam String username, @RequestParam String password) {
		return service.findByUserName(username, password);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Authenticator findOne(@PathVariable("id") String authenticatorId) {
		return service.findOne(authenticatorId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Authenticator create(@RequestBody Authenticator authenticator) {
		return service.create(authenticator);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Authenticator update(@PathVariable("id") String authenticatorId, @RequestBody Authenticator authenticator) {
		return service.update(authenticatorId, authenticator);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String authenticatorId) {
		service.remove(authenticatorId);
	}
}
