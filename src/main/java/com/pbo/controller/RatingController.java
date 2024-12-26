package com.pbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbo.model.Rating;
import com.pbo.model.User;
import com.pbo.repository.RatingRepository;

@RestController
@RequestMapping("/api/books/{bookId}/rating")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping
    public Rating createRating(@RequestBody Rating rating, @PathVariable String bookId) {
        String userId = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        rating.setUserId(userId);
        rating.setBookId(bookId);
        Rating exists = ratingRepository.findByUserIdAndBookId(userId, bookId);
        if (exists != null) {
            ratingRepository.delete(exists);
        }
        return ratingRepository.save(rating);
    }

    @GetMapping
    public List<Rating> getAllRatings(@PathVariable String bookId) {
        return ratingRepository.findAllByBookId(bookId);
    }
}
