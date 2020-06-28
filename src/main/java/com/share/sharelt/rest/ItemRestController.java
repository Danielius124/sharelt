package com.share.sharelt.rest;

import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.entity.Item;
import com.share.sharelt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ItemRestController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public List<Item> findAllUsers(){
        return  itemService.findAll();
    }
}
