package com.pbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pbo.model.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

  public List<Book> findTop10ByOrderByRatingtotalDesc();

}
