package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Address;
import com.movie.app.entity.Comment;
import com.movie.app.entity.Payment;
import com.movie.app.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User create(User user);

	public User findOne(String userId);

	public void delete(User user);

	public User update(User user);

	public List<Comment> findCommentList(String userId);

	public Address findAddress(String userId);

	public Payment findPayment(String userId);
}
