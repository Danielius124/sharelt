package com.share.sharelt.service;

import com.share.sharelt.dao.UserDetailsRepository;
import com.share.sharelt.entity.ItemPrices;
import com.share.sharelt.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class UserDetailsImpl implements UserDetailsService{

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public Optional<UserDetails> findById(long theId) {
        return userDetailsRepository.findById(theId);
    }

    @Override
    public List<UserDetails> findAll(){
        return userDetailsRepository.findAll();
    }

    @Override
    public void save(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public void delete(long theId){ userDetailsRepository.deleteById(theId);}
}
