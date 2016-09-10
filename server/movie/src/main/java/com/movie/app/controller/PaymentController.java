package com.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.entity.Payment;
import com.movie.app.service.PaymentService;

@RestController
@RequestMapping(value = "payments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PaymentController {
	@Autowired
	private PaymentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Payment> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Payment findOne(@PathVariable("id") String paymentId) {
		return service.findOne(paymentId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Payment create(@RequestBody Payment payment) {
		return service.create(payment);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Payment update(@PathVariable("id") String paymentId, @RequestBody Payment payment) {
		return service.update(paymentId, payment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String paymentId) {
		service.remove(paymentId);
	}
}
