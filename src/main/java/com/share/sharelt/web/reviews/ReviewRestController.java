package com.share.sharelt.web.reviews;

import com.share.sharelt.entity.reviews.Review;
import com.share.sharelt.exceptions.ApiRequestException;
import com.share.sharelt.services.items.ItemRentalService;
import com.share.sharelt.services.reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class ReviewRestController {


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
    public Review findById(@PathVariable long reviewId){
        if(reviewId < 0){
            throw new ApiRequestException("Id can't be negative.");
        }
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
