package com.share.sharelt.rest.items;

import com.share.sharelt.entity.items.Item;
import com.share.sharelt.service.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/owner/{itemId}")
    public long findOwnerByItemId(@PathVariable long itemId){
        return  itemService.findUserIdByItemId(itemId);
    }

    @PostMapping("/items")
    public Item addItem(@Valid @RequestBody Item theItem){
        theItem.setId((long) 0);

        itemService.save(theItem);

        return theItem;
    }

    @PutMapping("/items")
    public Item updateItem(@RequestBody Item theItem){
        itemService.save(theItem);

        return theItem;
    }

    @DeleteMapping("/items/{itemId}")
    public String deleteItem(@PathVariable long itemId){
        itemService.delete(itemId);

        return "Item with id - " + itemId + " was successfully deleted!";
    }
}
