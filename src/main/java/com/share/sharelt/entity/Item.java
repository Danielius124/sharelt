package com.share.sharelt.entity;


import javax.persistence.*;

@Entity
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
