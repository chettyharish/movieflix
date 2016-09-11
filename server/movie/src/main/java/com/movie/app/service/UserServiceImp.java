package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Address;
import com.movie.app.entity.Comment;
import com.movie.app.entity.Payment;
import com.movie.app.entity.User;
import com.movie.app.exception.UserNotFoundException;
import com.movie.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String userId) {
		User existingUser = repository.findOne(userId);

		if (existingUser == null) {
			throw new UserNotFoundException("User not found");
		}
		return existingUser;
	}

	@Override
	public List<Comment> findCommentList(String userId) {
		User existingUser = repository.findOne(userId);

		if (existingUser == null) {
			throw new UserNotFoundException("User not found");
		}
		return repository.findCommentList(userId);
	}

	@Override
	public Address findAddress(String userId) {
		User existingUser = repository.findOne(userId);

		if (existingUser == null) {
			throw new UserNotFoundException("User not found");
		}
		return repository.findAddress(userId);
	}

	@Override
	public Payment findPayment(String userId) {
		User existingUser = repository.findOne(userId);

		if (existingUser == null) {
			throw new UserNotFoundException("User not found");
		}
		return repository.findPayment(userId);
	}

	@Transactional
	@Override
	public User create(User user) {
		/* Allowing duplicates */
		return repository.create(user);
	}

	@Transactional
	@Override
	public User update(String userId, User user) {
		User existingUser = repository.findOne(userId);
		if (existingUser == null) {
			throw new UserNotFoundException("User already exists");
		}
		return repository.update(user);
	}

	@Transactional
	@Override
	public void remove(String userId) {
		User existingUser = repository.findOne(userId);
		if (existingUser == null) {
			throw new UserNotFoundException("User not found");
		}
		repository.delete(existingUser);

	}
}
