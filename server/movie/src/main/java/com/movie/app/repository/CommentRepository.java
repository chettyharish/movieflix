package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Comment;


public interface CommentRepository {
	public List<Comment> findAll();

	public Comment create(Comment comments);

	public Comment findOne(String commentsId);

	public void delete(Comment comments);

	public Comment update(Comment comments);
}
