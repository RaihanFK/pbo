package com.pbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbo.model.Review;
import com.pbo.repository.ReviewRepository;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PutMapping
    public Review editReview(@RequestBody Review review){
        return reviewRepository.put(review);
    }

    @DeleteMapping
    public Review deleteReview(@RequestBody Review review){
        return reviewRepository.delete(review);
    }
}
