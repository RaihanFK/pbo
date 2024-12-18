package com.pbo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "author")
	private String author;

	@Column(name = "genre")
	private String genre;

	@Column(name = "title")
	private String title;

    @Column(name = "published")
    private String published;

    @Column(name = "format")
    private String format;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "description")
    private String description;

    @Column(name = "book_image_url")
    private String bookImageUrl;

    @Column(name = "ratingtotal")
    private int ratingtotal;

    @Column(name = "ratingcount")
    private int ratingcount;

    public Book() {

    }

    public Book(String author, String genre, String title, String published, String format, String isbn, String description, String bookImageUrl) {
        this.author = author;
        this.genre = genre;
        this.title = title;
        // this.published = published;
        // this.format = format;
        // this.isbn = isbn;
        // this.description = description;
        // this.bookImageUrl = bookImageUrl;
        this.ratingtotal = 0;
        this.ratingcount = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
