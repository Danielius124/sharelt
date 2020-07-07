package com.share.sharelt.service;

import com.share.sharelt.dao.ItemRentalRepository;
import com.share.sharelt.dao.ReviewRepository;
import com.share.sharelt.entity.ItemRental;
import com.share.sharelt.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ItemRentalRepository itemRentalRepository;

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
        Optional<ItemRental> itemRentals = itemRentalRepository.findById(review.getRentalId());
        review.setRentalId(itemRentals.get().getId());
        review.setItemId(itemRentals.get().getItemID());
        review.setOwnerId(itemRentals.get().getOwnerId());
        review.setRenterId(itemRentals.get().getRenterId());
        review.setReviewDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));

        reviewRepository.save(review);
    }

    @Override
    public void delete(long theId) {
        reviewRepository.deleteById(theId);
    }
}

