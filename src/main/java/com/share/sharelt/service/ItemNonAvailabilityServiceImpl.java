package com.share.sharelt.service;

import com.share.sharelt.dao.ItemNonAvailabilityRepository;
import com.share.sharelt.entity.ItemNonAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemNonAvailabilityServiceImpl implements ItemNonAvailabilityService{

    @Autowired
    ItemNonAvailabilityRepository itemNonAvailabilityRepository;

    @Override
    public List<ItemNonAvailability> findAll() {
        return itemNonAvailabilityRepository.findAll();
    }

    @Override
    public Optional<ItemNonAvailability> findById(long theId) {
        return itemNonAvailabilityRepository.findById(theId);
    }

    @Override
    public void save(ItemNonAvailability itemNonAvailability) {
        itemNonAvailabilityRepository.save(itemNonAvailability);
    }

    @Override
    public void delete(long theId) {

        itemNonAvailabilityRepository.deleteById(theId);

    }
}
