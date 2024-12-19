package com.pbo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    List<Review> findByBookId(String bookId);

    Optional<Review> findByIdAndBookId(Long id, String bookId);
}
