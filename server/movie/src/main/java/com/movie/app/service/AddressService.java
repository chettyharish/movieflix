package com.movie.app.service;

import java.util.List;

import com.movie.app.entity.Address;

public interface AddressService {
	public List<Address> findAll();

	public Address findOne(String addressId);

	public Address create(Address address);

	public Address update(String addressId, Address address);

	public void remove(String addressId);

}
