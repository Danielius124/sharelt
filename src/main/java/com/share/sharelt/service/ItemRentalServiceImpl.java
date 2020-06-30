package com.share.sharelt.service;

import com.share.sharelt.dao.ItemRentalRepository;
import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.ItemRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemRentalServiceImpl implements ItemRentalService {

    @Autowired
    ItemRentalRepository itemRentalRepository;
    
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<ItemRental> findAll() {
        return itemRentalRepository.findAll();
    }

    @Override
    public Optional<ItemRental> findById(long theId) {
        return itemRentalRepository.findById(theId);
    }

    @Override
    public void save(ItemRental itemRental) {
        itemRentalRepository.save(itemRental);
    }

    @Override
    public void delete(long theId) {
        itemRentalRepository.deleteById(theId);
    }




}
