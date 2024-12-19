package com.pbo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_id")
	private String user_id;

	@Column(name = "book_id")
	private String book_id;

    @Column(name = "rating")
    private Integer rating;

    public Rating() {

    }

    public Rating(String user_id, String book_id, Integer rating) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.rating = rating;
    }
}
