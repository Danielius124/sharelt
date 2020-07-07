package com.share.sharelt.service;

import com.share.sharelt.dao.ReviewRepository;
import com.share.sharelt.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findById(long theId) {
        return reviewRepository.findById(theId);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void delete(long theId) {
        reviewRepository.deleteById(theId);
    }
}

