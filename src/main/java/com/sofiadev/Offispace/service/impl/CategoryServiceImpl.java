package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Category;
import com.sofiadev.Offispace.repository.CategoryRepository;
import com.sofiadev.Offispace.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) throws ResourceNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada con id" + id));
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se pudo actualizar la categoria con el id" + id));

        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) throws ResourceNotFoundException {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        } else{
            throw new ResourceNotFoundException("No se pudo eliminar la categoria con el id" + id);
        }

    }
}
