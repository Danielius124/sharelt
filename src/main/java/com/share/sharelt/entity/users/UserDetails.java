package com.share.sharelt.entity.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructors, getters, setters

    public UserDetails(){}


}
