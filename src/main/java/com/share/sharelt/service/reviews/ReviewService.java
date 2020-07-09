package com.share.sharelt.service.reviews;

import com.share.sharelt.entity.reviews.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> findAll();

    Optional<Review> findById(long theId);

    void save(Review review);

    void delete(long theId);
}
