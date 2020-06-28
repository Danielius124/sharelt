package com.share.sharelt.service;

import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
