package com.pbo.model;

import org.hibernate.annotations.GenericGenerator;

import com.pbo.util.IdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(generator = IdGenerator.GENERATOR_NAME)
    @GenericGenerator(name = IdGenerator.GENERATOR_NAME, strategy = "com.pbo.util.IdGenerator")
	private String id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

    @Column(name = "displayname")
    private String displayName;

    @Column(name = "password")
    private String password;

    public User() {

    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
