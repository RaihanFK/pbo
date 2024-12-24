package com.pbo.model;

import org.hibernate.annotations.GenericGenerator;

import com.pbo.util.IdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

	@Id
    @GeneratedValue(generator = IdGenerator.GENERATOR_NAME)
    @GenericGenerator(name = IdGenerator.GENERATOR_NAME, strategy = "com.pbo.util.IdGenerator")
	private String id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "book_id")
	private String bookId;

    @Column(name = "review")
    private String review;

    public Review() {

    }

    public Review(String userId, String bookId, String review) {
        this.userId = userId;
        this.bookId = bookId;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
