package com.pbo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "book_id")
	private String bookId;

    @Column(name = "rating")
    private Integer rating = 0;

    public Rating() {

    }

    public Rating(String userId, String bookId, Integer rating) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
    }
}
