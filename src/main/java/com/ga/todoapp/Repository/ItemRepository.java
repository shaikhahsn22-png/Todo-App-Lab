package com.ga.todoapp.Repository;


import com.ga.todoapp.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String itemName);
    List<Item> findItemByCategoryId(Long categoryId);

}
