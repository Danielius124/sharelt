package com.share.sharelt.service.users;

import com.share.sharelt.dao.users.UserDetailsRepository;
import com.share.sharelt.entity.reviews.Review;
import com.share.sharelt.entity.users.UserDetails;
import com.share.sharelt.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<UserDetails> result = userDetailsRepository.findAll();
        if(result.isEmpty()) {
            throw new ApiRequestException("Cannot find any user details.");
        }
        return result;
    }

    @Override
    public void save(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public void delete(long theId){ userDetailsRepository.deleteById(theId);}
}
