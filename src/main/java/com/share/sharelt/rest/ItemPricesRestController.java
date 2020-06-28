package com.share.sharelt.rest;

import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.ItemPrices;
import com.share.sharelt.service.ItemPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ItemPricesRestController {

    @Autowired
    ItemPricesService itemPricesService;

    @GetMapping("/itemPrices")
    public List<ItemPrices> findAllUsers(){
        return  itemPricesService.findAll();
    }
}
