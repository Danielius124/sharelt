package com.share.sharelt.rest;

import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.Review;
import com.share.sharelt.exception.ApiRequestException;
import com.share.sharelt.service.ItemRentalService;
import com.share.sharelt.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static java.util.Objects.isNull;

import javax.validation.constraints.Null;
import java.util.*;

@RestController
@RequestMapping("/")
public class ReviewRestController {

    int maxReviewTextSymbols = 50;

    @Autowired
    ReviewService reviewService;

    @Autowired
    ItemRentalService itemRentalService;
    private Object Null;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{reviewId}")
    public Optional<Review> findById(@PathVariable long reviewId){
        if(reviewId < 0){
            throw new ApiRequestException("Id can't be negative.");
        }
        return reviewService.findById(reviewId);
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review){

        checkExceptions(review);

        review.setId(0);

        reviewService.save(review);

        return review;
    }

    @PutMapping("/reviews")
    public Review updateReview(@RequestBody Review review){

        checkExceptions(review);

        reviewService.save(review);

        return review;
    }

    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable long reviewId){
        reviewService.delete(reviewId);

        return "Review with id - " + reviewId + " was successfully deleted!";
    }

    void checkExceptions(Review review){
        if(review.getRate() < 1 || review.getRate() > 5){
            throw new ApiRequestException("Rate must be between 1 and 5.");
        }
        if(review.getReviewText().isEmpty()){
            throw new ApiRequestException("Review text can't be empty.");
        }
        if(review.getReviewText().length() > maxReviewTextSymbols) {
            throw new ApiRequestException("Review text can't contain more than " + maxReviewTextSymbols + " symbols.");
        }
    }
}
