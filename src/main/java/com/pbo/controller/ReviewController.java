package com.pbo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbo.model.Review;
import com.pbo.repository.ReviewRepository;

@RestController
@RequestMapping("/api/books/{bookId}/review")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getReviewsByBookId(@PathVariable String bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @PutMapping
    public ResponseEntity<Review> updateReview(@RequestBody Review reviewDetails) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewDetails.getId());
        if (!reviewOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Review existingReview = reviewOptional.get();
        existingReview.setReview(reviewDetails.getReview());
        Review updatedReview = reviewRepository.save(existingReview);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteReview(@PathVariable Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(review.getId());
        if (!reviewOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } 

        reviewRepository.delete(reviewOptional.get());
        return ResponseEntity.noContent().build();
    }
}
