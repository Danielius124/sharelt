package com.share.sharelt.entity.users;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.share.sharelt.entity.items.Item;
import com.share.sharelt.validations.user.ValidPassword;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Email
    @NotEmpty
    @Column(name = "email")
    private String email;
    
    @ValidPassword
    @Column(name = "password")
    private String password;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", targetEntity = UserDetails.class, cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private UserDetails details;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", targetEntity = Item.class, cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Item> items;



    // Constructors, getters, setters

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
