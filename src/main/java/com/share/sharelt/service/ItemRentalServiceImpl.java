package com.share.sharelt.service;

import com.share.sharelt.dao.ItemRentalRepository;
import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.entity.ItemPrices;
import com.share.sharelt.entity.ItemRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
@Service
public class ItemRentalServiceImpl implements ItemRentalService {

    @Autowired
    ItemRentalRepository itemRentalRepository;

    @Autowired
    ItemService itemService;
    
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemPricesService itemPricesService;

    @Override
    public List<ItemRental> findAll() {
        return itemRentalRepository.findAll();
    }

    @Override
    public Optional<ItemRental> findById(long theId) {
        return itemRentalRepository.findById(theId);
    }

    @Override
    public void save(ItemRental itemRental) {
        itemRental.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        priceCalculator(itemRental);
        itemRental.setConfirmed(false); // setinam by default to false!!
        itemRental.setOwnerId(itemService.findUserIdByItemId(itemRental.getItemID())); // setOwnerId pagal item id Logika!!!!!!!!!!!
        rentalTimeDays(itemRental);

        itemRentalRepository.save(itemRental);

    }


    @Override
    public void delete(long theId) {
        itemRentalRepository.deleteById(theId);
    }

    private long rentalTimeDays(ItemRental itemRental) {
        // Parsing the date
        LocalDate dateBefore = LocalDate.parse(itemRental.getRentBegin());
        LocalDate dateAfter = LocalDate.parse(itemRental.getRentEnd());

        // calc
        long rentalDays = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        return rentalDays;
    }

    // SLIAUKA REIKES DARYTI Su STREAM
    private void priceCalculator(ItemRental itemRental) {

        long rentalDaysToCalc = rentalTimeDays(itemRental);
        int max = 0;
        long maxId = 0;
        List<ItemPrices> itemPrices = itemPricesService.findByItemId(itemRental.getItemID());
        for(ItemPrices x : itemPrices){
            if(x.getDay() > max && rentalDaysToCalc >= x.getDay() ){
                max = x.getDay();
                maxId = x.getId();
            }
        }

        BigDecimal costForRent;

        costForRent = BigDecimal.valueOf(rentalDaysToCalc * (itemPricesService.findById(maxId).get().getPrice()));

        itemRental.setCost(costForRent.setScale(2,BigDecimal.ROUND_HALF_EVEN)); // cia bus kainos nustatymo logika!!
    }



}
