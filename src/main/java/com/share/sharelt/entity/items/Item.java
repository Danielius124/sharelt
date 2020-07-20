package com.share.sharelt.entity.items;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.share.sharelt.entity.users.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "item_value")
    private double itemValue;

    @Column(name = "deposit")
    private double deposit;

    @JsonManagedReference
    @OneToMany(mappedBy = "item", targetEntity = ItemPrices.class, cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<ItemPrices> prices;

    @JsonManagedReference
    @OneToMany(mappedBy = "item", targetEntity = ItemNonAvailability.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<ItemNonAvailability> availabilities;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;



    public Item(){

    }

}
