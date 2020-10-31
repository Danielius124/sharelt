package com.share.sharelt.repositories.reviews;

import com.share.sharelt.entity.reviews.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
