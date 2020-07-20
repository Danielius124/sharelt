package com.share.sharelt.rest.users;

import com.share.sharelt.entity.users.UserDetails;
import com.share.sharelt.service.users.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserDetailsRestController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/userDetails")
    public List<UserDetails> findAll(){
        return  userDetailsService.findAll();
    }

    @GetMapping("/userDetails/{userDetailsId}")
    public UserDetails findById(@PathVariable long userDetailsId){
        return userDetailsService.findById(userDetailsId);
    }

    @PostMapping("/userDetails")
    public UserDetails addUserDetails(@RequestBody UserDetails userDetails){
        userDetails.setId(0);

        userDetailsService.save(userDetails);

        return userDetails;
    }

    @PutMapping("userDetails")
    public UserDetails updateUserDetails(@RequestBody UserDetails userDetails){
        userDetailsService.save(userDetails);

        return userDetails;
    }

    @DeleteMapping("/userDetails/{userDetailId}")
    public String deleteUserDetails(@PathVariable long userDetailId){
        userDetailsService.delete(userDetailId);
        return "User details successfully deleted!";
    }
}
