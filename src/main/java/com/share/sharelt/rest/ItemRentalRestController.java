package com.share.sharelt.rest;

import com.share.sharelt.entity.ItemRental;
import com.share.sharelt.service.ItemRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/")
public class ItemRentalRestController {

    @Autowired
    ItemRentalService itemRentalService;

    @GetMapping("/rental")
    public List<ItemRental> findAll(){
        return itemRentalService.findAll();
    }

    @GetMapping("/rental/{rentalId}")
    public Optional<ItemRental> findById(@PathVariable long rentalId){
        return itemRentalService.findById(rentalId);
    }

    @PostMapping("/rental")
    public ItemRental addRental(@RequestBody ItemRental itemRental){
        itemRental.setId(0);

        itemRentalService.save(itemRental);

        return itemRental;
    }

    @PutMapping("/rental")
    public ItemRental updateRental(@RequestBody ItemRental itemRental){
        itemRentalService.save(itemRental);

        return itemRental;
    }

    @DeleteMapping("/rental/{rentalId}")
    public String deleteById(@PathVariable long rentalId){
        itemRentalService.delete(rentalId);

        return "Your rental was successfully deleted!";
    }


}
