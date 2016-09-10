package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
