package com.share.sharelt.service.items;

import com.share.sharelt.entity.items.ItemPrices;

import java.util.List;
import java.util.Optional;

public interface ItemPricesService {

    List<ItemPrices> findAll();

    Optional<ItemPrices> findById(long theId);

    List<ItemPrices> findByItemId(long itemId);

    void save(ItemPrices itemPrices);

    void delete(long theId);

}
