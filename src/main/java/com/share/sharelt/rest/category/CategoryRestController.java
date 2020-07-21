package com.share.sharelt.rest.category;

import com.share.sharelt.entity.category.Category;
import com.share.sharelt.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/")
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/category/{theId}")
    public Optional<Category> getCategory(@PathVariable long theId){
        return categoryService.findById(theId);
    }

    @GetMapping("/categoryPath/{theId}")
    public List<Category> getPathOfCategories(@PathVariable long theId){
        return categoryService.getPathOfCategories(theId);
    }
}
