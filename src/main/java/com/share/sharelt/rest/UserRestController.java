package com.share.sharelt.rest;

import com.share.sharelt.entity.User;
import com.share.sharelt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{theId}")
    public User findById(@PathVariable long theId){
        return userService.findById(theId);
    }
}
