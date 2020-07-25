package com.share.sharelt.rest.users;

import com.share.sharelt.entity.users.User;
import com.share.sharelt.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public User addUser(@Valid @RequestBody User theUser){
        theUser.setId(0);

        userService.save(theUser);

        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User theUser){
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
