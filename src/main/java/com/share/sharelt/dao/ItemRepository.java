package com.share.sharelt.dao;

import com.share.sharelt.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT user_id FROM items b WHERE b.id = :id", nativeQuery = true)
    long findUserIdByItemId(@Param("id")long itemId);
}
