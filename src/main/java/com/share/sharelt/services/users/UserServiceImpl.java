package com.share.sharelt.services.users;

import com.share.sharelt.repositories.users.UserRepository;
import com.share.sharelt.entity.users.User;
import com.share.sharelt.exceptions.ApiRequestException;
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
        List<User> result = userRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot find any users.");
        }
        return result;
    }

    @Override
    public User findById(long theId) {
        Optional<User> result = userRepository.findById(theId);

        User user = null;
        if(result.isPresent()){
            user = result.get();
        }else throw new ApiRequestException("Cannot find user with id: " + theId + "!");

        return user;
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
