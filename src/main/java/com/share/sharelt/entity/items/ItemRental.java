package com.share.sharelt.entity.items;


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
    private String created;

    @Column(name = "cost")
    BigDecimal cost;


    @Column(name = "rent_begin")
    private String rentBegin;

    @Column(name = "rent_end")
    private String rentEnd;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "renter_id")
    private long renterId;

    @Column(name = "item_id")
    private long itemID;

    @Column(name = "owner_id")
    private long ownerId;


    public ItemRental(){}
    
}
