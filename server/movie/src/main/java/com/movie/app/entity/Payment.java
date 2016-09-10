package com.movie.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Payment.findAll", query = "SELECT p from Payment p "),
		@NamedQuery(name = "Payment.findByCCNumber", query = "SELECT p from Payment p where p.ccNumber=:pCCNumber") })
public class Payment {
	@Id
	private String paymentId;
	private String ccType;
	private String ccName;
	private String ccNumber;
	private int ccCVV;
	private DateTime expiryDate;

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

	public DateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(DateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", ccType=" + ccType + ", ccName=" + ccName + ", ccNumber="
				+ ccNumber + ", ccCVV=" + ccCVV + ", expiryDate=" + expiryDate + "]";
	}

}
