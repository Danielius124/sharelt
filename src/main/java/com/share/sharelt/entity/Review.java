package com.share.sharelt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long id;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "rental_id")
    private long rentalId;

    @Column(name = "item_id")
    private long itemId;

    @Column(name = "owner_id")
    private long ownerId;

    @Column(name = "renter_id")
    private long renterId;

    @Column(name = "rate")
    private int rate;

    @Column(name = "review_date")
    private String reviewDate;

    public Review(){}
}
