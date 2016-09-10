package com.movie.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movie.app.entity.Payment;

@Repository
public class PaymentRepositoryImp implements PaymentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Payment> findAll() {
		TypedQuery<Payment> query = em.createNamedQuery("Payment.findAll", Payment.class);
		return query.getResultList();
	}

	@Override
	public Payment findOne(String paymentId) {
		return em.find(Payment.class, paymentId);
	}

	@Override
	public Payment create(Payment payment) {
		em.persist(payment);
		return payment;
	}

	@Override
	public Payment update(Payment payment) {
		return em.merge(payment);
	}

	@Override
	public void delete(Payment payment) {
		em.remove(payment);
	}

	@Override
	public Payment findByCcNumber(String ccNumber) {
		TypedQuery<Payment> query = em.createNamedQuery("Payment.findByCcNumber", Payment.class);
		query.setParameter("pCCNumber", ccNumber);
		List<Payment> payment = query.getResultList();
		if (payment.size() == 1) {
			return payment.get(0);
		} else {
			return null;
		}
	}

}
