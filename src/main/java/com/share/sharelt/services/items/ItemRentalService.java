package com.share.sharelt.services.items;

import com.share.sharelt.entity.items.ItemRental;
import java.util.*;


public interface ItemRentalService {

    List<ItemRental> findAll();

    ItemRental findById(long theId);

    void save(ItemRental itemRental);

    void delete(long theId);

}
