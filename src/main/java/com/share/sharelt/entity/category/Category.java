package com.share.sharelt.entity.category;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = true)
    Long parentId;

    String title;

    public Category(){
    }

}
