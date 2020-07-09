package com.share.sharelt.service.users;

import com.share.sharelt.entity.users.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(long theId);

    void save(User theUser);

    void delete(long theId);
}
