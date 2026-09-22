package com.ga.todoapp.Controller;

import com.ga.todoapp.Model.Category;
import com.ga.todoapp.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //get all categories
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        System.out.println("calling getAllCategories()");
        return categoryService.getAllCategories();
    }

    //create category
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        System.out.println("Calling createCategory()");
        return categoryService.createCategory(categoryObject);
    }

    //get category by id
    @GetMapping("/categories/{id}")
    public Optional<Category> getCategory(@PathVariable Long id){
        System.out.println("Calling getCategory()");
        return categoryService.getCategory(id);
    }
}
