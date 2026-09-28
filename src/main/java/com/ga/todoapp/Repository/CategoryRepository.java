package com.ga.todoapp.Repository;
import com.ga.todoapp.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);

    //Category findByIdAndUserId(Long categoryId, Long userId);

    List<Category> findByUserId(Long userId);
    Optional<Category> findByIdAndUserId(Long categoryId, Long userId);

    Category findByUserIdAndName(Long UserId, String categoryName);


}
