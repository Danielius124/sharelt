package com.share.sharelt.rest;

import com.share.sharelt.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserDetailsRestController {

    @Autowired
    UserDetailsService userDetailsService;
}
