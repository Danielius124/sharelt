package com.share.sharelt.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "item_rental")
public class ItemRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "created")
    private Date created;

    @Column(name = "cost")
    BigDecimal cost;

    @Column(name = "rent_begin")
    private Date rentBegin;

    @Column(name = "rent_end")
    private Date rentEnd;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;


    @JsonProperty("renter_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "renter_id", nullable = true)
    private User user;

    @JsonProperty("item_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", nullable = true)
    private Item item;

    @Column(name = "owner_id")
    private long ownerId;


    public ItemRental(){};

}
