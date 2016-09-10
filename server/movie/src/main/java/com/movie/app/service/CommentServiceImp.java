package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Comment;
import com.movie.app.exception.CommentNotFoundException;
import com.movie.app.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	private CommentRepository repository;

	@Override
	public List<Comment> findAll() {
		return repository.findAll();
	}

	@Override
	public Comment findOne(String commentId) {
		Comment existingComment = repository.findOne(commentId);

		if (existingComment == null) {
			throw new CommentNotFoundException("Comment not found");
		}
		return existingComment;
	}

	@Transactional
	@Override
	public Comment create(Comment comment) {
		/* Allowing duplicates*/
		return repository.create(comment);
	}

	@Transactional
	@Override
	public Comment update(String commentId, Comment comment) {
		Comment existingComment = repository.findOne(commentId);
		if (existingComment == null) {
			throw new CommentNotFoundException("Comment already exists");
		}
		return repository.update(comment);
	}

	@Transactional
	@Override
	public void remove(String commentId) {
		Comment existingComment = repository.findOne(commentId);
		if (existingComment == null) {
			throw new CommentNotFoundException("Comment not found");
		}
		repository.delete(existingComment);

	}
}
