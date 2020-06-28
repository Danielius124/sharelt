package com.share.sharelt.service;

import com.share.sharelt.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long theId);
}
