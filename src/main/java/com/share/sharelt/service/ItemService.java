package com.share.sharelt.service;

import com.share.sharelt.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(long theId);

    long findUserIdByItemId(long itemId);

    void save(Item theItem);

    void delete(long theId);
}
