package com.share.sharelt.rest;

import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.Review;
import com.share.sharelt.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{reviewId}")
    public Optional<Review> findById(@PathVariable long reviewId){
        return reviewService.findById(reviewId);
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review){
        review.setId(0);

        reviewService.save(review);

        return review;
    }

    @PutMapping("/reviews")
    public Review updateReview(@RequestBody Review review){
        reviewService.save(review);

        return review;
    }

    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable long reviewId){
        reviewService.delete(reviewId);

        return "Review with id - " + reviewId + " was successfully deleted!";
    }
}
