package edu.sandip.blog_app_apis.services.impl;

import edu.sandip.blog_app_apis.entities.Category;
import edu.sandip.blog_app_apis.exceptions.ResourceNotFoundException;
import edu.sandip.blog_app_apis.payloads.CategoryDTO;
import edu.sandip.blog_app_apis.repositories.CategoryRepository;
import edu.sandip.blog_app_apis.services.CategoryService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(
            @NonNull final CategoryRepository categoryRepository,
            @NonNull final ModelMapper modelMapper
    ) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category newCategory = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.save(newCategory);
        return convertCategoryToCategoryDTO(savedCategory);
    }

    @Override
    public CategoryDTO readSingleCategoryItem(Integer categoryId) {
        Category categoryById = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        return convertCategoryToCategoryDTO(categoryById);
    }

    @Override
    public List<CategoryDTO> readAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(this::convertCategoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO convertCategoryToCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category toModifyCategory = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        modelMapper.map(categoryDTO, toModifyCategory);
        toModifyCategory.setCategoryId(categoryId);
        Category updatedCategory = categoryRepository.save(toModifyCategory);
        return convertCategoryToCategoryDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category toModifyCategory = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        categoryRepository.delete(toModifyCategory);
    }
}
