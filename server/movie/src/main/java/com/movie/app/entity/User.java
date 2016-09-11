package com.movie.app.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries({

		@NamedQuery(name = "User.findAll", query = "SELECT u from User u "),
		@NamedQuery(name = "User.findOne", query = "SELECT u from User u where u.userId = :pId "),
		@NamedQuery(name = "User.findCommentList", query = "SELECT c from User u JOIN Comment c where u.userId = :pId"),
		@NamedQuery(name = "User.findAddress", query = "SELECT u.address from User u where u.userId = :pId"),
		@NamedQuery(name = "User.findPayment", query = "SELECT u.payment from User u where u.userId = :pId")

})
public class User {

	@Id
	private String userId;

	@JsonProperty("FirstName")
	private String firstName;

	@JsonProperty("LastName")
	private String lastName;

	@JsonProperty("PhoneNumber")
	private String phoneNumber;

	@JsonProperty("EmailAddress")
	private String emailAddress;

	@JsonProperty("Gender")
	private String gender;

	@JsonProperty("CreateDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createDate;

	@JsonProperty("UpdateDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date updateDate;

	// @OneToOne
	// private Authenticator authenticator;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Payment payment;

	@OneToMany
	private List<Comment> commentList;

	public User() {
		userId = UUID.randomUUID().toString();
	}

	public String getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	// public Authenticator getAuthenticator() {
	// return authenticator;
	// }
	//
	// public void setAuthenticator(Authenticator authenticator) {
	// this.authenticator = authenticator;
	// }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", gender=" + gender + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", address=" + address + ", payment=" + payment + ", commentList="
				+ commentList + "]";
	}

}
