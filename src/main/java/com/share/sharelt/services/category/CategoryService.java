package com.share.sharelt.services.category;

import com.share.sharelt.entity.category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(long theId);

    void save(Category category);

    void delete(long theId);

    public List<Category> getPathOfCategories(long theId);
}
