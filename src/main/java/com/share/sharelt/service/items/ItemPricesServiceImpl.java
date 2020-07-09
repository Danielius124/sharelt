package com.share.sharelt.service.items;

import com.share.sharelt.dao.items.ItemPricesRepository;
import com.share.sharelt.entity.items.ItemPrices;
import com.share.sharelt.exception.ApiRequestException;
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
        List<ItemPrices> result = itemPricesRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot found any prices");
        }
        return result;
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
