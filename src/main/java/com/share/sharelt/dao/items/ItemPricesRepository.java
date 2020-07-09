package com.share.sharelt.dao.items;

import com.share.sharelt.entity.items.ItemPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemPricesRepository extends JpaRepository<ItemPrices, Long> {

    @Query(value = "SELECT * FROM item_prices p WHERE p.item_id = :item_id", nativeQuery = true)
    List<ItemPrices> findByItemId(@Param("item_id") long itemId);
}
