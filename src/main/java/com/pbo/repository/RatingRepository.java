package com.pbo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    public List<Rating> findAllByBookId(String bookId);

    public Rating findByUserIdAndBookId(String userId, String bookId);
}
