package com.beans;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Transaction implements Serializable {
	private Long     id;
	private Client   client;
    private Artisan  artisan;
    private DateTime date;
    private String validation;
    private String message;
    private String justification;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Artisan getArtisan() {
		return artisan;
	}
	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}

}