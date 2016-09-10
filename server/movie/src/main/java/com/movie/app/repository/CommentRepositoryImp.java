package com.movie.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movie.app.entity.Comment;

@Repository
public class CommentRepositoryImp implements CommentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment findOne(String commentId) {
		return em.find(Comment.class, commentId);
	}

	@Override
	public Comment create(Comment comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public void delete(Comment comment) {
		em.remove(comment);
	}

}
