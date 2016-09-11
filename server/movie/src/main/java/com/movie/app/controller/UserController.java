package com.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.entity.Address;
import com.movie.app.entity.Comment;
import com.movie.app.entity.Payment;
import com.movie.app.entity.User;
import com.movie.app.service.UserService;

@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}/comments")
	public List<Comment> findCommentList(@PathVariable("id") String userId) {
		return service.findCommentList(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}/addresses")
	public Address findAddress(@PathVariable("id") String userId) {
		return service.findAddress(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}/payments")
	public Payment findPayment(@PathVariable("id") String userId) {
		return service.findPayment(userId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String userId, @RequestBody User user) {
		return service.update(userId, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String userId) {
		service.remove(userId);
	}
}
