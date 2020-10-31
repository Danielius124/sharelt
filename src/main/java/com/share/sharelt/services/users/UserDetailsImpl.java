package com.share.sharelt.services.users;

import com.share.sharelt.repositories.users.UserDetailsRepository;
import com.share.sharelt.entity.users.UserDetails;
import com.share.sharelt.exceptions.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService{

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails findById(long theId) {

        Optional<UserDetails> result = userDetailsRepository.findById(theId);

        UserDetails userDetails = null;
        if(result.isPresent()){
            userDetails = result.get();
        }else throw new ApiRequestException("Cannot find user details with id: " + theId + "!");

        return userDetails;
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
