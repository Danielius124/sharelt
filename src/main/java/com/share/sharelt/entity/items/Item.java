package com.share.sharelt.entity.items;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.share.sharelt.entity.users.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 5, max = 45)
    @Column(name = "item_name")
    private String itemName;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Column(name = "item_value")
    private double itemValue;

    @NotEmpty
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getItemValue() {
        return itemValue;
    }

    public void setItemValue(double itemValue) {
        this.itemValue = itemValue;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public List<ItemPrices> getPrices() {
        return prices;
    }

    public void setPrices(List<ItemPrices> prices) {
        this.prices = prices;
    }

    public List<ItemNonAvailability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<ItemNonAvailability> availabilities) {
        this.availabilities = availabilities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
