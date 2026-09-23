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

    public Category updateCategory(Long id, Category categoryObject){
        System.out.println("Service calling updateCategory()  ==>");
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()){
            Category updateCategory = category.get();
            updateCategory.setName(categoryObject.getName());
            updateCategory.setDescription(categoryObject.getDescription());
            return categoryRepository.save(updateCategory);
        } else {
            throw new InformationNotFoundException("Category with id " + id + " not found");
        }

    }

    public Optional<Category> deleteCategory(Long id){
        System.out.println("Service calling deleteCategory()  ==>");
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()){
            categoryRepository.deleteById(id);
            return category;
        } else {
            throw new InformationNotFoundException("Category with id " + id + " not found");
        }

    }
}
