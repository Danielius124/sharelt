package com.share.sharelt.services.items;

import com.share.sharelt.entity.items.ItemNonAvailability;

import java.util.*;

public interface ItemNonAvailabilityService {

    List<ItemNonAvailability> findAll();

    ItemNonAvailability findById(long theId);

    void save(ItemNonAvailability itemNonAvailability);

    void delete(long theId);
}
