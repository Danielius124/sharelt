package com.share.sharelt.service;

import com.share.sharelt.dao.ItemPricesRepository;
import com.share.sharelt.entity.ItemPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPricesServiceImpl implements ItemPricesService {


    @Autowired
    ItemPricesRepository itemPricesRepository;

    @Override
    public List<ItemPrices> findAll() {
        return itemPricesRepository.findAll();
    }
}
