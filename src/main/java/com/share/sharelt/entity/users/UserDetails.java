package com.share.sharelt.entity.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.share.sharelt.validations.user.ValidPhone;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
@Table(name="user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Column(name = "first_name")
    private String first_name;

    @NotEmpty
    @Column(name = "last_name")
    private String last_name;

    @NotEmpty
    @Column(name = "birth_date")
    private Date birth_date;

    @NotEmpty
    @ValidPhone
    @Column(name = "phone_number")
    private String phone_number;

    @NotEmpty
    @Column(name = "country")
    private String country;

    @NotEmpty
    @Column(name = "city")
    private String city;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructors, getters, setters

    public UserDetails(){}


}
