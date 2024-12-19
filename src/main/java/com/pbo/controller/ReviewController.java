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
    public Review addReview(@PathVariable String bookId, @RequestBody Review review) {
        review.setIdBook(bookId);
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getReviewsByBookId(@PathVariable String bookId) {
        return reviewRepository.findByIdBook(bookId);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable String bookId,
            @PathVariable Long reviewId,
            @RequestBody Review reviewDetails) {
        Optional<Review> reviewOptional = reviewRepository.findByIdAndIdBook(reviewId, bookId);
        if (reviewOptional.isPresent()) {
            Review existingReview = reviewOptional.get();
            existingReview.setReview(reviewDetails.getReview());
            Review updatedReview = reviewRepository.save(existingReview);
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable String bookId, @PathVariable Long reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findByIdAndIdBook(reviewId, bookId);
        if (reviewOptional.isPresent()) {
            reviewRepository.delete(reviewOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
