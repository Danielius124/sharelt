package com.share.sharelt.services.items;

import com.share.sharelt.repositories.items.ItemRepository;
import com.share.sharelt.entity.items.Item;
import com.share.sharelt.exceptions.ApiRequestException;
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
    public Item findByItemId(long theId) {
        Optional<Item> result = itemRepository.findById(theId);

        Item theItem = null;

        if (result.isPresent()) {
            theItem = result.get();
        }
        else throw new ApiRequestException("No item with id: " +  theId + " found!!!");

        return theItem;
    }

    @Override
    public long findUserIdByItemId(long itemId) {
        return itemRepository.findUserIdByItemId(itemId);
    }

    @Override
    public Item save(Item theItem) {
        itemRepository.save(theItem);
        return theItem;
    }

    @Override
    public void delete(long theId) {
        itemRepository.deleteById(theId);
    }
}