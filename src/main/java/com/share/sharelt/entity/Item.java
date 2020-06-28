package com.share.sharelt.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "item", targetEntity = com.share.sharelt.entity.ItemPrices.class, cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    @Column(nullable = true)
    private List<ItemPrices> prices;

    // Constructors, getters, setters!!!

    public Item(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Item(String itemName, String description, double itemValue, double deposit) {
        this.itemName = itemName;
        this.description = description;
        this.itemValue = itemValue;
        this.deposit = deposit;
    }
}
