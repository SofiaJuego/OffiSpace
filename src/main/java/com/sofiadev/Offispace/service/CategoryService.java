package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id) throws ResourceNotFoundException;

    Category updateCategory(Long id, Category category) throws ResourceNotFoundException;

    void deleteCategory(Long id) throws ResourceNotFoundException;


}
