package com.movie.app.service;

import java.util.List;

import com.movie.app.entity.Comment;

public interface CommentService {

	public List<Comment> findAll();

	public Comment findOne(String commentId);

	public Comment create(Comment comment);

	public Comment update(String commentId, Comment comment);

	public void remove(String commentId);
}
