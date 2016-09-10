package com.movie.app.repository;

import java.util.List;

import com.movie.app.entity.Address;

public interface AddressRepository {

	public List<Address> findAll();

	public Address create(Address address);

	public Address findOne(String addressId);

	public void delete(Address address);

	public Address update(Address address);

}
