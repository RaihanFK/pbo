package com.pbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbo.model.Rating;
import com.pbo.repository.RatingRepository;

@RestController
@RequestMapping("/api/ratings")

public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
