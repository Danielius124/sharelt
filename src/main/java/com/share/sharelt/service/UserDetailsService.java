package com.share.sharelt.service;

import com.share.sharelt.entity.UserDetails;

import java.util.Optional;

public interface UserDetailsService {
    Optional<UserDetails> findById(long theId);
}
