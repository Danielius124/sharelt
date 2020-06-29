package com.share.sharelt.service;

import com.share.sharelt.entity.ItemNonAvailability;

import java.util.*;

public interface ItemNonAvailabilityService {

    List<ItemNonAvailability> findAll();

    Optional<ItemNonAvailability> findById(long theId);

    void save(ItemNonAvailability itemNonAvailability);

    void delete(long theId);
}