package com.pbo.model;

import org.hibernate.annotations.GenericGenerator;

import com.pbo.util.IdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {

	@Id
    @GeneratedValue(generator = IdGenerator.GENERATOR_NAME)
    @GenericGenerator(name = IdGenerator.GENERATOR_NAME, strategy = "com.pbo.util.IdGenerator")
	private String id;

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

    public void setBookId(String bookId) {
	this.bookId = bookId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public Integer getRating() {
	return rating;
    }
}
