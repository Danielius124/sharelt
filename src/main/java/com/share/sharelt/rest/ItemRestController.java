package com.share.sharelt.rest;

import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.entity.Item;
import com.share.sharelt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/items/{itemId}")
    public Item findById(@PathVariable long itemId){
        return itemService.findById(itemId);
    }

    @PostMapping("/items")
    public Item addItem(@RequestBody Item theItem){
        theItem.setId(0);

        itemService.save(theItem);

        return theItem;
    }

    @PutMapping("/items")
    public Item updateItem(@RequestBody Item theItem){
        itemService.save(theItem);

        return theItem;
    }

    @DeleteMapping("/items/{itemId}")
    public String deleteBuilding(@PathVariable long itemId){
        itemService.delete(itemId);

        return "Building with id - " + itemId + " was successfully deleted!";
    }
}
