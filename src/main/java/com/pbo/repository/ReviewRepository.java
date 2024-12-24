package com.pbo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public Optional<Review> findById(String id);

    public List<Review> findAllByBookId(String bookId);

    public Optional<Review> findByIdAndBookId(String id, String bookId);
}
