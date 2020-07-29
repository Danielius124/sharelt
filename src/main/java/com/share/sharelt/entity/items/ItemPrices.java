package com.share.sharelt.entity.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@Table(name = "item_prices")
public class ItemPrices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "minimum_days")
    private int day;

    @Column(name = "day_price")
    private double price;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "item_id", nullable = true)
    private Item item;

    public ItemPrices(){}


}
