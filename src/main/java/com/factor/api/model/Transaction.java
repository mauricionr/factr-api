package com.factor.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtransaction;

	@NotBlank
	private String trustIDFrom;

	@NotBlank
	private String trustIDTo;

	private Float value;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date timestamp;

	public Long getIdtransaction() {
		return idtransaction;
	}

	public void setIdtransaction(Long idtransaction) {
		this.idtransaction = idtransaction;
	}

	public String getTrustIDFrom() {
		return trustIDFrom;
	}

	public void setTrustIDFrom(String trustIDFrom) {
		this.trustIDFrom = trustIDFrom;
	}

	public String getTrustIDTo() {
		return trustIDTo;
	}

	public void setTrustIDTo(String trustIDTo) {
		this.trustIDTo = trustIDTo;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
