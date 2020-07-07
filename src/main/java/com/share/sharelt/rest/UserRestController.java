package com.share.sharelt.rest;

import com.share.sharelt.entity.Item;
import com.share.sharelt.entity.User;
import com.share.sharelt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{userId}")
    public User findById(@PathVariable long userId){
        return userService.findById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser){
        theUser.setId(0);

        userService.save(theUser);

        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser){
        userService.save(theUser);

        return theUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable long userId){
        userService.delete(userId);

        return "User with id - " + userId + " was successfully deleted!";
    }

    // TODO: 1.endpointo kuris grazina visus reviews apie useri

}
