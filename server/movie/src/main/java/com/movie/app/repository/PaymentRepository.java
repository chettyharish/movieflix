package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Payment;

public interface PaymentRepository {
	public List<Payment> findAll();

	public Payment create(Payment payment);

	public Payment findOne(String paymentId);

	public void delete(Payment payment);

	public Payment update(Payment payment);

	public Payment findByCcNumber(String ccNumber);
}
