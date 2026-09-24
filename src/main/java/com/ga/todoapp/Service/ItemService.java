package com.ga.todoapp.Service;

import com.ga.todoapp.Exception.InformationNotFoundException;
import com.ga.todoapp.Model.Category;
import com.ga.todoapp.Model.Item;
import com.ga.todoapp.Repository.CategoryRepository;
import com.ga.todoapp.Repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    //create an item
    public Item createItem(Long categoryId, Item item){
        System.out.println("Service calling createItem ==>");
        Category category =categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("category with id " + categoryId + " not found"));
        item.setCategory(category);
        return itemRepository.save(item);
    }

    //get all items for a category
    public List<Item> getItems(Long categoryId){
        System.out.println("Service calling getItems ==>");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("category with id " + categoryId + " not found"));

        List<Item> items = itemRepository.findItemByCategoryId(categoryId);
        return items;
    }

    //get an item
    public Item getItem(Long categoryId, Long itemId){
        System.out.println("Service calling getItem()  ==>");
        //find item by categoryId
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            Optional<Item> item = itemRepository.findItemByCategoryId(categoryId).stream().filter(
                    p -> p.getId().equals(itemId)).findFirst();
            if (item.isEmpty()){
                throw new InformationNotFoundException("Item with id " + itemId + " not found");
            } else {
                return item.get();
            }

        }else {
            throw new InformationNotFoundException("Category id: " + categoryId + " not found.");
        }
    }

    //update an item
    public Item updateItem(Long categoryId, Long itemId, Item itemObject){
        System.out.println("Service calling updateItem()  ==>");

        //find category by categoryId
        categoryRepository.findById(categoryId).orElseThrow(() ->
                new InformationNotFoundException("category with id " + categoryId + " not found"));

        //find recipe inside that category
        Item item = itemRepository.findItemByCategoryId(categoryId).stream().filter(
                p -> p.getId().equals(itemId)).findFirst().orElseThrow(() ->
                new InformationNotFoundException("Item with id " + itemId + " not found"));

        //update item fields
        item.setName(itemObject.getName());
        item.setDescription(itemObject.getDescription());
        item.setDueDate(itemObject.getDueDate());

        return itemRepository.save(item); //save and return the updated item

    }

    //delete item
    public void deleteItem(Long categoryId, Long itemId){
        System.out.println("Service calling deleteItem()  ==>");

        //find category by categoryId
        categoryRepository.findById(categoryId).orElseThrow(() ->
                new InformationNotFoundException("category with id " + categoryId + " not found"));

        //find Item inside that category
        Item item = itemRepository.findItemByCategoryId(categoryId).stream().filter(
                p -> p.getId().equals(itemId)).findFirst().orElseThrow(() ->
                new InformationNotFoundException("Item with id " + itemId + " not found"));

        itemRepository.deleteById(item.getId());

    }
}
