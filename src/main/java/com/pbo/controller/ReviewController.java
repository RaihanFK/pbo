package com.pbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pbo.model.Review;
import com.pbo.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books/{bookId}/review")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    // POST: Add a new review for a book
    @PostMapping
    public Review addReview(@PathVariable String bookId, @RequestBody Review review) {
        review.setIdBook(bookId); // Set the bookId for this review
        return reviewRepository.save(review);
    }

    // GET: Retrieve all reviews for a specific book
    @GetMapping
    public List<Review> getReviewsByBookId(@PathVariable String bookId) {
        return reviewRepository.findByIdBook(bookId);
    }

    // PUT: Update a specific review for a book
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable String bookId,
            @PathVariable Long reviewId,
            @RequestBody Review reviewDetails) {
        Optional<Review> reviewOptional = reviewRepository.findByIdAndIdBook(reviewId, bookId);
        if (reviewOptional.isPresent()) {
            Review existingReview = reviewOptional.get();
            existingReview.setReview(reviewDetails.getReview()); // Update review text
            Review updatedReview = reviewRepository.save(existingReview);
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Delete a specific review for a book
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
