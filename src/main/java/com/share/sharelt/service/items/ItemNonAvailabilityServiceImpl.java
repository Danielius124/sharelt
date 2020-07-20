package com.share.sharelt.service.items;

import com.share.sharelt.dao.items.ItemNonAvailabilityRepository;
import com.share.sharelt.entity.items.ItemNonAvailability;
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
    public ItemNonAvailability findById(long theId) {
        Optional<ItemNonAvailability> result = itemNonAvailabilityRepository.findById(theId);

        ItemNonAvailability itemNonAvailability = null;
        if(result.isPresent()){
            itemNonAvailability = result.get();
        }else throw new ApiRequestException("Cannot find any rental with id: " + theId + "!!");


        return itemNonAvailability;
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
