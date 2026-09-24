package com.ga.todoapp.Controller;

import com.ga.todoapp.Model.Item;
import com.ga.todoapp.Service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ItemController {
    private ItemService itemService;

    //create an item
    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(@PathVariable(value = "categoryId") Long categoryId,
                           @RequestBody Item itemObject ){
        System.out.println("calling createItem");
        return itemService.createItem(categoryId,itemObject);
    }

    //get all items for a category
    @GetMapping("/categories/{categoryId}/items")
    public List<Item> getItems(@PathVariable Long categoryId){
        System.out.println("calling getItems");
        return itemService.getItems(categoryId);
    }

    //get item
    @GetMapping("/categories/{categoryId}/items/{itemId}")
    public Item getItem(@PathVariable(value = "categoryId") Long categoryId,
                            @PathVariable(value = "itemId") Long itemId){
        System.out.println("calling getItem");
        return itemService.getItem(categoryId, itemId);
    }

    //update item
    @PutMapping("/categories/{categoryId}/items/{itemId}")
    public Item updateItem(@PathVariable(value = "categoryId") Long categoryId,
                               @PathVariable(value = "itemId") Long itemId,
                               @RequestBody Item itemObject){
        System.out.println("calling updateItem");
        return  itemService.updateItem(categoryId, itemId, itemObject);
    }

    //delete item
    @DeleteMapping("/categories/{categoryId}/items/{itemId}")
    public void deleteItem(@PathVariable(value = "categoryId") Long categoryId,
                             @PathVariable(value = "itemId") Long itemId){
        System.out.println("calling deleteItem ==>");
        itemService.deleteItem(categoryId,itemId);
    }




}
