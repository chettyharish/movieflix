package com.movie.app.service;

import java.util.List;

import com.movie.app.entity.Address;
import com.movie.app.entity.Comment;
import com.movie.app.entity.Payment;
import com.movie.app.entity.User;

public interface UserService {
	public List<User> findAll();

	public User findOne(String userId);

	public User create(User user);

	public User update(String userId, User user);

	public void remove(String userId);

	List<Comment> findCommentList(String userId);

	public Payment findPayment(String userId);

	public Address findAddress(String userId);

}
