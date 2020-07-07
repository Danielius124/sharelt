package com.share.sharelt.rest;

import com.share.sharelt.entity.Review;
import com.share.sharelt.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
@RequestMapping("/")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewService.findAll();
    }
}
