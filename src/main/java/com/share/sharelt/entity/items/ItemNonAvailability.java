package com.share.sharelt.entity.items;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.share.sharelt.validations.user.ValidDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "item_non_availability")
public class ItemNonAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ValidDate
    @Column(name = "begin_date")
    private Date beginDate;

    @ValidDate
    @Column(name = "end_date")
    private Date endDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "item_id", nullable = true)
    private Item item;

    public ItemNonAvailability(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
