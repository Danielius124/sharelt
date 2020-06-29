package com.share.sharelt.rest;

import com.share.sharelt.entity.ItemNonAvailability;
import com.share.sharelt.service.ItemNonAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/")
public class ItemNonAvailabilityRestController {

    @Autowired
    ItemNonAvailabilityService itemNonAvailabilityService;

    @GetMapping("/availability")
    public List<ItemNonAvailability> findAll() {
        return itemNonAvailabilityService.findAll();
    }


    @GetMapping("/availability/{itemId}")
    public Optional<ItemNonAvailability> findById(@PathVariable long itemId) {
        return itemNonAvailabilityService.findById(itemId);

    }

    @PostMapping("/availability")
    public ItemNonAvailability addAvailability(@RequestBody ItemNonAvailability itemNonAvailability){
        itemNonAvailability.setId(0);

        itemNonAvailabilityService.save(itemNonAvailability);

        return itemNonAvailability;
    }

    @PutMapping("/availability")
    public ItemNonAvailability updateAvailability(@RequestBody ItemNonAvailability itemNonAvailability){
        itemNonAvailabilityService.save(itemNonAvailability);

        return itemNonAvailability;
    }

    @DeleteMapping("/availability/{itemId}")
    public String deleteAvailability(@PathVariable long itemId){
        itemNonAvailabilityService.delete(itemId);

        return "Item Availability was susccessfully deleted!!";
    }
}