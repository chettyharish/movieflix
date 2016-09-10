package com.movie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.entity.Address;
import com.movie.app.service.AddressService;

@RestController
@RequestMapping(value = "addresses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AddressController {
	@Autowired
	private AddressService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Address> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Address findOne(@PathVariable("id") String addressId) {
		return service.findOne(addressId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Address create(@RequestBody Address address) {
		return service.create(address);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Address update(@PathVariable("id") String addressId, @RequestBody Address address) {
		return service.update(addressId, address);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String addressId) {
		service.remove(addressId);
	}
}
