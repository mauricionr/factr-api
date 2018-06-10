package com.factr.api.model;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "wallet")
@EntityListeners(AuditingEntityListener.class)
public class Wallet {

	@Id
	@NotBlank
	private String trustID;

	@NotBlank
	private String password;

	private Float value;

	public String getTrustID() {
		return trustID;
	}

	public void setTrustID(String trustID) {
		this.trustID = trustID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
}
