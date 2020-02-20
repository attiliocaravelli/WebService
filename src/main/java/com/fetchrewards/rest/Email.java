package com.fetchrewards.rest;

public class Email {

	String value;
	
	public String getEmail() {
		return value;
	}

	public void setName(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Email [email=" + value + "]";
	}

}