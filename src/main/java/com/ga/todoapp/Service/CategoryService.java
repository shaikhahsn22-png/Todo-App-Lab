package com.ga.todoapp.Service;

import com.ga.todoapp.Exception.InformationExistException;
import com.ga.todoapp.Exception.InformationNotFoundException;
import com.ga.todoapp.Model.Category;
import com.ga.todoapp.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        System.out.println("service calling getAllCategories() ==>");
        return categoryRepository.findAll();
    }


    public Category createCategory(Category categoryObject){
        System.out.println("service calling createCategory() ==>");
        Category category = categoryRepository.findByName(categoryObject.getName());
        if(category != null){
            throw new InformationExistException("Category with name " + category.getName() + " already exists.");
        }

        return categoryRepository.save(categoryObject);

    }

    public Optional<Category> getCategory(Long id){
        System.out.println("service calling getCategory() ==>");
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category;
        }else {
            throw new InformationNotFoundException("Category id: " + id + " not found.");
        }
    }
}
