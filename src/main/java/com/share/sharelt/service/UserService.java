package com.share.sharelt.service;

import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(long theId);

    void save(User theUser);

    void delete(long theId);
}
