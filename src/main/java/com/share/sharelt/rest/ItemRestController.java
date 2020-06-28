package com.share.sharelt.rest;

import com.share.sharelt.dao.ItemRepository;
import com.share.sharelt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemRestController {

    @Autowired
    ItemService itemService;
}
