package com.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.entity.Comment;
import com.movie.app.service.CommentService;

@RestController
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {
	@Autowired
	private CommentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Comment findOne(@PathVariable("id") String commentId) {
		return service.findOne(commentId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@RequestBody Comment comment) {
		return service.create(comment);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment update(@PathVariable("id") String commentId, @RequestBody Comment comment) {
		return service.update(commentId, comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String commentId) {
		service.remove(commentId);
	}
}
