package com.share.sharelt.service.category;

import com.share.sharelt.dao.category.CategoryRepository;
import com.share.sharelt.entity.category.Category;
import com.share.sharelt.exception.ApiExceptionHandler;
import com.share.sharelt.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long theId) {
        return categoryRepository.findById(theId);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long theId) {
        categoryRepository.deleteById(theId);
    }

    @Override
    public List<Category> getPathOfCategories(long theId) {
        Optional<Category> result = categoryRepository.findById(theId);
        List<Category> categories = new ArrayList<>();
        long tarpId = theId;
        while(result.get().getParentId() != null){
            categories.add(result.get());
            tarpId = result.get().getParentId();
            categoryRepository.findById(tarpId);
        }
        result = categoryRepository.findById(tarpId);
        categories.add(result.get());


        if(categories == null){
            throw new ApiRequestException("No categories found");
        }
        return categories;
    }
}
