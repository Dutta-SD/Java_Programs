package edu.sandip.blog_app_apis.services;

import edu.sandip.blog_app_apis.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {
    // Create -- POST
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    // Read -- GET
    CategoryDTO readSingleCategoryItem(Integer categoryId);

    // Read All -- GET
    List<CategoryDTO> readAllCategories();

    // Update -- PUT
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);

    // Delete -- DELETE
    void deleteCategory(Integer categoryId);
}
