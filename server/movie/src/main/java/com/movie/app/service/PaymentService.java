package com.movie.app.service;

import java.util.List;

import com.movie.app.entity.Payment;

public interface PaymentService {

	public List<Payment> findAll();

	public Payment findOne(String paymentId);

	public Payment create(Payment payment);

	public Payment update(String paymentId, Payment payment);

	public void remove(String paymentId);
}
