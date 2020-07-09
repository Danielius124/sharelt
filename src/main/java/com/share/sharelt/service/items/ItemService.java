package com.share.sharelt.service.items;

import com.share.sharelt.entity.items.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(long theId);

    long findUserIdByItemId(long itemId);

    void save(Item theItem);

    void delete(long theId);
}
