package com.share.sharelt.service.items;

import com.share.sharelt.dao.items.ItemNonAvailabilityRepository;
import com.share.sharelt.entity.items.ItemNonAvailability;
import com.share.sharelt.entity.items.ItemPrices;
import com.share.sharelt.exception.ApiRequestException;
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
        List<ItemNonAvailability> result = itemNonAvailabilityRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot find any non availabilities for items.");
        }
        return result;
    }

    @Override
    public Optional<ItemNonAvailability> findById(long theId) {
        return itemNonAvailabilityRepository.findById(theId);
    }

    @Override
    public void save(ItemNonAvailability itemNonAvailability) {
        ItemNonAvailability result = itemNonAvailability;
        if(result.equals(null)){
            throw new ApiRequestException("");
        }

        itemNonAvailabilityRepository.save(itemNonAvailability);
    }

    @Override
    public void delete(long theId) {

        itemNonAvailabilityRepository.deleteById(theId);

    }
}
