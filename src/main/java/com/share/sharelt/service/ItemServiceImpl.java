package com.share.sharelt.service;

import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(long theId) {
        Optional<Item> result = itemRepository.findById(theId);

        Item theItem = null;

        if (result.isPresent()) {
            theItem = result.get();
        }

        return theItem;
    }

    @Override
    public void save(Item theItem) {
        itemRepository.save(theItem);
    }

    @Override
    public void delete(long theId) {
        itemRepository.deleteById(theId);
    }
}