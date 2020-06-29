package com.share.sharelt.service;

import com.share.sharelt.entity.ItemPrices;
import com.share.sharelt.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    Optional<UserDetails> findById(long theId);

    List<UserDetails> findAll();

    void save(UserDetails userDetails);

    void delete(long theId);
}
