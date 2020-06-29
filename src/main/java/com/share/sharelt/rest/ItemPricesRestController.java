package com.share.sharelt.rest;

import com.share.sharelt.entity.ItemPrices;
import com.share.sharelt.service.ItemPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ItemPricesRestController {

    @Autowired
    ItemPricesService itemPricesService;

    @GetMapping("/itemPrices")
    public List<ItemPrices> findAllPrices(){
        return  itemPricesService.findAll();
    }

    @GetMapping("/itemPrices/{itemPriceId}")
    public Optional<ItemPrices> findById(@PathVariable long itemPriceId){
        return itemPricesService.findById(itemPriceId);
    }

    @PostMapping("/itemPrices")
    public ItemPrices addItemPrice(@RequestBody ItemPrices itemPrices){
        itemPrices.setId(0);

        itemPricesService.save(itemPrices);

        return itemPrices;
    }

    @PutMapping("/itemPrices")
    public ItemPrices updateItemPrice(@RequestBody ItemPrices itemPrices){
        itemPricesService.save(itemPrices);

        return itemPrices;
    }

    @DeleteMapping("/itemPrices/{itemPriceId}")
    public String deleteItemPrice(@PathVariable long itemPriceId){
        itemPricesService.delete(itemPriceId);
        return "Item Price successfully deleted!";
    }
}
