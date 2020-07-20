package com.share.sharelt.service.items;

import com.share.sharelt.dao.items.ItemRentalRepository;
import com.share.sharelt.entity.items.ItemPrices;
import com.share.sharelt.entity.items.ItemRental;
import com.share.sharelt.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemRentalServiceImpl implements ItemRentalService {

    @Autowired
    ItemRentalRepository itemRentalRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemPricesService itemPricesService;

    @Override
    public List<ItemRental> findAll() {
        List<ItemRental> result = itemRentalRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot find any item rentals.");
        }
        return result;
    }

    @Override
    public ItemRental findById(long theId) {
        Optional<ItemRental> result = itemRentalRepository.findById(theId);

        ItemRental itemRental = null;
        if(result.isPresent()){
            itemRental = result.get();
        }else throw new ApiRequestException("Cannot find any rental with id: " + theId + "!!");

        return itemRental;
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
        final int[] max = {0};
        final AtomicLong[] maxId = {new AtomicLong()};
        List<ItemPrices> itemPrices = itemPricesService.findByItemId(itemRental.getItemID());
        itemPrices.stream()
        .forEach(i ->{
          if(i.getDay() > max[0] && rentalDaysToCalc >= i.getDay()){
              max[0] = i.getDay();
              maxId[0].set(i.getId());
            }
        });

        BigDecimal costForRent;

        costForRent = BigDecimal.valueOf(rentalDaysToCalc * (itemPricesService.findById(maxId[0].get()).get().getPrice()));

        itemRental.setCost(costForRent.setScale(2,BigDecimal.ROUND_DOWN)); // cia bus kainos nustatymo logika!!
    }



}
