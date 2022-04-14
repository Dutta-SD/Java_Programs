package edu.sandip.blog_app_apis.controllers;


import edu.sandip.blog_app_apis.payloads.ApiResponse;
import edu.sandip.blog_app_apis.payloads.CategoryDTO;
import edu.sandip.blog_app_apis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

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
    public ResponseEntity<CategoryDTO> createNewCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO newCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(newCategoryDTO, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId) {
        CategoryDTO updatedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        ApiResponse successDeletedResponse = new ApiResponse();
        successDeletedResponse.setMessage("Resource Deleted Successfully");
        return new ResponseEntity<>(successDeletedResponse, HttpStatus.OK);

    }


}
