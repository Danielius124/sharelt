package com.share.sharelt.service;

import com.share.sharelt.dao.ItemPricesRepository;
import com.share.sharelt.entity.ItemPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPricesServiceImpl implements ItemPricesService {


    @Autowired
    ItemPricesRepository itemPricesRepository;

    @Override
    public List<ItemPrices> findAll() {
        return itemPricesRepository.findAll();
    }

    @Override
    public Optional<ItemPrices> findById(long theId) {

        return itemPricesRepository.findById(theId);
    }

    @Override
    public List<ItemPrices> findByItemId(long itemId) {
        return itemPricesRepository.findByItemId(itemId);
    }

    @Override
    public void save(ItemPrices itemPrices) {
        itemPricesRepository.save(itemPrices);
    }

    @Override
    public void delete(long theId) {
        itemPricesRepository.deleteById(theId);
    }
}
