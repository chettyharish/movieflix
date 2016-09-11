package com.movie.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movie.app.entity.Address;
import com.movie.app.entity.Comment;
import com.movie.app.entity.Payment;
import com.movie.app.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String userId) {
		return em.find(User.class, userId);
	}
	
	@Override
	public List<Comment> findCommentList(String userId){
		TypedQuery<Comment> query = em.createNamedQuery("User.findCommentList", Comment.class);
		query.setParameter("pId", userId);
		return query.getResultList();
	}
	
	@Override
	public Address findAddress(String userId){
		TypedQuery<Address> query = em.createNamedQuery("User.findAddress", Address.class);
		query.setParameter("pId", userId);

		List<Address> address = query.getResultList();
		if (address.size() == 1) {
			return address.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Payment findPayment(String userId){
		TypedQuery<Payment> query = em.createNamedQuery("User.findPayment", Payment.class);
		query.setParameter("pId", userId);
		System.out.println(userId);
		List<Payment> payment = query.getResultList();
		if (payment.size() == 1) {
			return payment.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}


}
