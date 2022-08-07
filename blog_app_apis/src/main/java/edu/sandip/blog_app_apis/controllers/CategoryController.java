package edu.sandip.blog_app_apis.controllers;


import edu.sandip.blog_app_apis.payloads.ApiResponse;
import edu.sandip.blog_app_apis.payloads.CategoryDTO;
import edu.sandip.blog_app_apis.services.CategoryService;
import edu.sandip.blog_app_apis.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getSingleCategory(@PathVariable Integer categoryId) {
        CategoryDTO categoryDTO = categoryService.readSingleCategoryItem(categoryId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOS = categoryService.readAllCategories();
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CategoryDTO> createNewCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO newCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(newCategoryDTO, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId) {
        CategoryDTO updatedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
        System.out.println(categoryService.getClass());
        categoryService.deleteCategory(categoryId);
        ApiResponse successDeletedResponse = getSuccessfulDeleteApiResponse();
        return new ResponseEntity<>(successDeletedResponse, HttpStatus.OK);
    }

    private ApiResponse getSuccessfulDeleteApiResponse() {
        ApiResponse successDeletedResponse = new ApiResponse();
        successDeletedResponse.setMessage(Constants.RESOURCE_DELETED_SUCCESSFULLY);
        return successDeletedResponse;
    }
}
