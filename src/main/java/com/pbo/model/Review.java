package com.pbo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "id_user")
	private String idUser;

	@Column(name = "id_book")
	private String idBook;

    @Column(name = "review")
    private String review;

    public Review() {

    }

    public Review(String idUser, String idBook, String review) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.review = review;
    }
}
