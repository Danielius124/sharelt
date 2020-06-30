package com.share.sharelt.service;

import com.share.sharelt.entity.ItemRental;
import java.util.*;


public interface ItemRentalService {

    List<ItemRental> findAll();

    Optional<ItemRental> findById(long theId);

    void save(ItemRental itemRental);

    void delete(long theId);


}
