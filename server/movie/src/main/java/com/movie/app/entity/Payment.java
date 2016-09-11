package com.movie.app.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries({

		@NamedQuery(name = "Payment.findAll", query = "SELECT p from Payment p "),
		@NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p from Payment p where p.paymentId=:ppaymentId")

})
public class Payment {

	@Id
	private String paymentId;

	@JsonProperty("CCType")
	private String ccType;

	@JsonProperty("CCName")
	private String ccName;

	@JsonProperty("CCNumber")
	private String ccNumber;

	@JsonProperty("CCCVV")
	private int ccCVV;

	@JsonProperty("ExpiryDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expiryDate;

	public Payment() {
		paymentId = UUID.randomUUID().toString();
	}

	public String getPaymentId() {
		return paymentId;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public int getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(int ccCVV) {
		this.ccCVV = ccCVV;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", ccType=" + ccType + ", ccName=" + ccName + ", ccNumber="
				+ ccNumber + ", ccCVV=" + ccCVV + ", expiryDate=" + expiryDate + "]";
	}

}
