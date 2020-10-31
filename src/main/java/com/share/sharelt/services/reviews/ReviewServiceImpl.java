package com.share.sharelt.services.reviews;

import com.share.sharelt.repositories.items.ItemRentalRepository;
import com.share.sharelt.repositories.reviews.ReviewRepository;
import com.share.sharelt.entity.items.ItemRental;
import com.share.sharelt.entity.reviews.Review;
import com.share.sharelt.exceptions.ApiRequestException;
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
        List<Review> result = reviewRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot find any reviews.");
        }
        return result;
    }

    @Override
    public Review findById(long theId) {
        Optional<Review> result = reviewRepository.findById(theId);

        Review review = null;
        if(result.isPresent()){
            review = result.get();
        }else throw new ApiRequestException("Cannot find review with id: " + theId + "!!");

        return review;

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

