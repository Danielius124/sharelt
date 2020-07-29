package com.share.sharelt.entity.category;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = true)
    Long parentId;

    @NotEmpty
    String title;

    public Category(){
    }

}
