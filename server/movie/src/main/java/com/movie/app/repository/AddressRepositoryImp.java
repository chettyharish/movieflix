package com.movie.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movie.app.entity.Address;

@Repository
public class AddressRepositoryImp implements AddressRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Address> findAll() {
		TypedQuery<Address> query = em.createNamedQuery("Address.findAll", Address.class);
		return query.getResultList();
	}

	@Override
	public Address findOne(String addressId) {
		return em.find(Address.class, addressId);
	}

	@Override
	public Address create(Address address) {
		em.persist(address);
		return address;
	}

	@Override
	public Address update(Address address) {
		return em.merge(address);
	}

	@Override
	public void delete(Address address) {
		em.remove(address);
	}

}
