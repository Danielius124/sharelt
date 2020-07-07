package com.share.sharelt.service;

import com.share.sharelt.entity.ItemNonAvailability;
import com.share.sharelt.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> findAll();

    Optional<Review> findById(long theId);

    void save(Review review);

    void delete(long theId);
}
