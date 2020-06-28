package com.share.sharelt.service;

import com.share.sharelt.entity.ItemPrices;

import java.util.List;
import java.util.Optional;

public interface ItemPricesService {

    List<ItemPrices> findAll();

    Optional<ItemPrices> findById(long theId);

    void save(ItemPrices itemPrices);

    void delete(long theId);

}
