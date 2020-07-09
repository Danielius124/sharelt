package com.share.sharelt.service.items;

import com.share.sharelt.entity.items.ItemRental;
import java.util.*;


public interface ItemRentalService {

    List<ItemRental> findAll();

    Optional<ItemRental> findById(long theId);

    void save(ItemRental itemRental);

    void delete(long theId);

}