package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Payment;
import com.movie.app.exception.PaymentExistsException;
import com.movie.app.exception.PaymentNotFoundException;
import com.movie.app.repository.PaymentRepository;

@Service
public class PaymentServiceImp implements PaymentService {
	@Autowired
	private PaymentRepository repository;

	@Override
	public List<Payment> findAll() {
		return repository.findAll();
	}

	@Override
	public Payment findOne(String paymentId) {
		Payment existingPayment = repository.findOne(paymentId);

		if (existingPayment == null) {
			throw new PaymentNotFoundException("Payment not found");
		}
		return existingPayment;
	}

	@Transactional
	@Override
	public Payment create(Payment payment) {
		Payment existingMovie = repository.findByCcNumber(payment.getCcNumber());
		if (existingMovie != null) {
			throw new PaymentExistsException("Movie Already Exists");
		}

		return repository.create(payment);
	}

	@Transactional
	@Override
	public Payment update(String paymentId, Payment payment) {
		Payment existingPayment = repository.findOne(paymentId);
		if (existingPayment == null) {
			throw new PaymentNotFoundException("Payment already exists");
		}
		return repository.update(payment);
	}

	@Transactional
	@Override
	public void remove(String paymentId) {
		Payment existingPayment = repository.findOne(paymentId);
		if (existingPayment == null) {
			throw new PaymentNotFoundException("Payment not found");
		}
		repository.delete(existingPayment);

	}
}
