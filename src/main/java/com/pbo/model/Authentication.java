package com.pbo.model;

import org.hibernate.annotations.GenericGenerator;

import com.pbo.util.IdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authentications")
public class Authentication {

	@Id
    @GeneratedValue(generator = IdGenerator.GENERATOR_NAME)
    @GenericGenerator(name = IdGenerator.GENERATOR_NAME, strategy = "com.pbo.util.IdGenerator")
	private String id;
	
	@Column(name = "token", nullable = false)
	private String token;
	
	public Authentication() {
	}
	
	public Authentication(String token) {
		this.token = token;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}
