package com.share.sharelt.service.items;

import com.share.sharelt.dao.items.ItemRepository;
import com.share.sharelt.entity.items.Item;
import com.share.sharelt.entity.items.ItemRental;
import com.share.sharelt.exception.ApiRequestException;
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
        List<Item> result = itemRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot find any items.");
        }
        return result;
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
    public long findUserIdByItemId(long itemId) {

        return itemRepository.findUserIdByItemId(itemId);
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