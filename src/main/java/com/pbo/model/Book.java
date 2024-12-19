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

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "published", columnDefinition = "TEXT")
    private String published;

	@Column(name = "author", columnDefinition = "TEXT")
	private String author;

	@Column(name = "genre", columnDefinition = "TEXT")
	private String genre;

    @Column(name = "format", columnDefinition = "TEXT")
    private String format;

    @Column(name = "isbn", columnDefinition = "TEXT")
    private String isbn;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "book_image_url", columnDefinition = "TEXT")
    private String bookImageUrl;

    @Column(name = "rating_total")
    private Integer ratingTotal = 0;

    @Column(name = "rating_count")
    private Integer ratingCount = 0;

    public Book() {

    }

    public Book(String title, String published, String author, String genre, String format, String isbn, String description) {
        this.author = author;
        this.published = published;
        this.genre = genre;
        this.title = title;
        this.format = format;
        this.isbn = isbn;
        this.description = description;
        this.bookImageUrl = "-";
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

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public int getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(int ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

}
