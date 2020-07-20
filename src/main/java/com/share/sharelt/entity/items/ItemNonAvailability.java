package com.share.sharelt.entity.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "item_non_availability")
public class ItemNonAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "begin_date")
    private Date beginDate;


    @Column(name = "end_date")
    private Date endDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", nullable = true)
    private Item item;

    public ItemNonAvailability(){}
}
