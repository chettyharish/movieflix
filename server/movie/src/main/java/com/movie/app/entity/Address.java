package com.movie.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Address.findAll", query = "SELECT a from Address a ") })
public class Address {

	@Id
	private String addressId;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String country;
	private int zipCode;

	public Address() {
		addressId = UUID.randomUUID().toString();
	}

	public String getAddressId() {
		return addressId;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressOne=" + addressOne + ", addressTwo=" + addressTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}

}
