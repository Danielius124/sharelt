package com.share.sharelt.service;

import com.share.sharelt.dao.UserRepository;
import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }

        return theUser;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void delete(long theId) {
        userRepository.deleteById(theId);
    }
}
