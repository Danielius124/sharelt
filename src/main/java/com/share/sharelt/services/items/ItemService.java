package com.share.sharelt.services.items;

import com.share.sharelt.entity.items.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findByItemId(long theId);

    long findUserIdByItemId(long itemId);

    Item save(Item theItem);

    void delete(long theId);
}
