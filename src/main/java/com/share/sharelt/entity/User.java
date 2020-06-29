package com.share.sharelt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

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


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

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
}
