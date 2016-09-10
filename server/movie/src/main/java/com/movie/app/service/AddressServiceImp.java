package com.movie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.app.entity.Address;
import com.movie.app.exception.AddressNotFoundException;
import com.movie.app.repository.AddressRepository;

@Service
public class AddressServiceImp implements AddressService {
	@Autowired
	private AddressRepository repository;

	@Override
	public List<Address> findAll() {
		return repository.findAll();
	}

	@Override
	public Address findOne(String addressId) {
		Address existingAddress = repository.findOne(addressId);

		if (existingAddress == null) {
			throw new AddressNotFoundException("Address not found");
		}
		return existingAddress;
	}

	@Transactional
	@Override
	public Address create(Address address) {
		/* Allowing duplicates*/
		return repository.create(address);
	}

	@Transactional
	@Override
	public Address update(String addressId, Address address) {
		Address existingAddress = repository.findOne(addressId);
		if (existingAddress == null) {
			throw new AddressNotFoundException("Address already exists");
		}
		return repository.update(address);
	}

	@Transactional
	@Override
	public void remove(String addressId) {
		Address existingAddress = repository.findOne(addressId);
		if (existingAddress == null) {
			throw new AddressNotFoundException("Address not found");
		}
		repository.delete(existingAddress);

	}
}
