package com.share.sharelt.entity.items;


import lombok.Data;


import javax.persistence.*;
import java.math.BigDecimal;

import java.util.Date;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getRentBegin() {
        return rentBegin;
    }

    public void setRentBegin(String rentBegin) {
        this.rentBegin = rentBegin;
    }

    public String getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(String rentEnd) {
        this.rentEnd = rentEnd;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public long getRenterId() {
        return renterId;
    }

    public void setRenterId(long renterId) {
        this.renterId = renterId;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
