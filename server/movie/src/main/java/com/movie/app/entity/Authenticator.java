package com.movie.app.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.app.enumeration.AccessType;

@Entity
@Table
@NamedQueries({

		@NamedQuery(name = "Authenticator.findByUserName", query = "SELECT a from Authenticator a where a.userName=:pUserName AND a.password=:pPassword")

})
public class Authenticator {

	@Id
	private String authenticatorId;

	@Column(unique = true)
	@JsonProperty("UserName")
	private String userName;

	@JsonProperty("Password")
	private String password;

	@JsonProperty("Type")
	private AccessType type;

	@OneToOne
	private User user;

	public Authenticator() {
		authenticatorId = UUID.randomUUID().toString();
	}

	public void setAuthenticatorId(String authenticatorId) {
		this.authenticatorId = authenticatorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccessType getType() {
		return type;
	}

	public void setType(AccessType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Authenticator [authenticatorId=" + authenticatorId + ", userName=" + userName + ", password=" + password
				+ ", type=" + type + ", user=" + user + "]";
	}

}
