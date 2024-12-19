package com.pbo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findTop10ByOrderByRatingTotalDesc();

}
