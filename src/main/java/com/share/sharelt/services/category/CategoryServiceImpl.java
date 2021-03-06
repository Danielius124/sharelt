package com.share.sharelt.services.category;

import com.share.sharelt.repositories.category.CategoryRepository;
import com.share.sharelt.entity.category.Category;
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
        categories.add(result.get());
        while(result.get().getParentId() != null){
            tarpId = result.get().getParentId();
            result = categoryRepository.findById(tarpId);
            categories.add(result.get());
        }

        return categories;
    }
}
