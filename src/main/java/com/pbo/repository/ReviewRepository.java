package com.pbo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

  // Find all reviews by bookId
  List<Review> findByIdBook(String idBook);

  // Find a specific review by id and bookId
  Optional<Review> findByIdAndIdBook(Long id, String idBook);
}
