package com.share.sharelt.services.users;

import com.share.sharelt.entity.users.UserDetails;

import java.util.List;

public interface UserDetailsService {
    UserDetails findById(long theId);

    List<UserDetails> findAll();

    void save(UserDetails userDetails);

    void delete(long theId);
}
