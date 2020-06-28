package com.share.sharelt.service;

import com.share.sharelt.dao.UserDetailsRepository;
import com.share.sharelt.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService{

    @Autowired
    UserDetailsRepository userDetailsRepository;


    @Override
    public Optional<UserDetails> findById(long theId) {
        return userDetailsRepository.findById(theId);
    }
}
