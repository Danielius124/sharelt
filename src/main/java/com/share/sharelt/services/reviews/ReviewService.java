package com.share.sharelt.services.reviews;

import com.share.sharelt.entity.reviews.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    Review findById(long theId);

    void save(Review review);

    void delete(long theId);
}
