package com.share.sharelt.rest;

import com.share.sharelt.entity.ItemRental;
import com.share.sharelt.service.ItemRentalService;
import com.share.sharelt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
@RestController
@RequestMapping("/")
public class ItemRentalRestController {

    @Autowired
    ItemRentalService itemRentalService;

    @Autowired
    ItemService itemService;

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

        itemRental.setId(0); // create hibernate new ENTITY
        itemRental.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        itemRental.setCost(BigDecimal.valueOf(548.45)); // cia bus kainos nustatymo logika!!
        itemRental.setConfirmed(false); // setinam by default to false!!
        itemRental.setOwnerId(itemService.findUserIdByItemId(itemRental.getItemID())); // setOwnerId pagal item id Logika!!!!!!!!!!!

        // Parsing the date
        LocalDate dateBefore = LocalDate.parse(itemRental.getRentBegin());
        LocalDate dateAfter = LocalDate.parse(itemRental.getRentEnd());

        // calc
        long numbOfDays = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        System.out.println(numbOfDays);

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
