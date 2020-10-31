package com.share.sharelt.web.items;

import com.share.sharelt.entity.items.Item;
import com.share.sharelt.services.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {

    @Autowired
    ItemService itemService;

    @GetMapping()
    public Iterable<Item> getAllItems(){

        return itemService.findAll();
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> findItemById(@PathVariable long itemId){

        Item item = itemService.findByItemId(itemId);
        int a =0;
        int b =0;
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }


    @GetMapping("/owner/{itemId}") //TODO Klausimas ar reikalingas
    public long findOwnerByItemId(@PathVariable long itemId){
        return  itemService.findUserIdByItemId(itemId);
    }

    @PostMapping("/items")
    public ResponseEntity<?> addItem(@Valid @RequestBody Item theItem, BindingResult result){

        //TODO VALIDATIONS

        Item item1 = itemService.save(theItem);

        return new ResponseEntity<Item>(item1, HttpStatus.OK);
    }

    @PatchMapping("/items")
    public ResponseEntity<Item> updateItem(@RequestBody Item theItem){
        itemService.save(theItem);

        return new ResponseEntity<Item>(theItem, HttpStatus.OK);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable long itemId){
        itemService.delete(itemId);

        return new ResponseEntity<String>("Item with id: "+itemId+" was deleted successfully", HttpStatus.OK);
    }
}
