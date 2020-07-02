package com.share.sharelt.dao;

import com.share.sharelt.entity.ItemRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static org.hibernate.loader.Loader.*;

public interface ItemRentalRepository extends JpaRepository<ItemRental, Long> {

}
