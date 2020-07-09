package com.share.sharelt.service.users;

import com.share.sharelt.entity.users.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    Optional<UserDetails> findById(long theId);

    List<UserDetails> findAll();

    void save(UserDetails userDetails);

    void delete(long theId);
}
