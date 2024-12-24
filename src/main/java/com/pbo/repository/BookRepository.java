package com.pbo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pbo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional <Book> findById(String id);

    public List<Book> findTop10ByOrderByRatingTotalDesc();

    @Query("SELECT b FROM Book b WHERE TO_DATE(b.published, 'Month DD, YYYY') > :currentDate ORDER BY TO_DATE(b.published, 'Month DD, YYYY') ASC")
    public List<Book> findUpcomingBooks(@Param("currentDate") LocalDate currentDate);

    public List<Book> findByTitleContainingIgnoreCase(String title);
}
