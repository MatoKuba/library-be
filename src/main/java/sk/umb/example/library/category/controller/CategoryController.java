package sk.umb.example.library.category.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @GetMapping("/api/categories")
    public void listCategory(@RequestParam(required = false) String name){
        System.out.println("Search category called.");
    }

    @GetMapping("/api/categories/{categoryId}")
    public void getCategory(@PathVariable Long categoryId){
        System.out.println("Get category called.");
    }
    
    @PostMapping("/api/categories")
    public void createCategory(){
        System.out.println("Create category called.");
    }

    @PutMapping("/api/categories/{categoryId}")
    public void updateCategory(@PathVariable Long categoryId){
        System.out.println("Update category called: ID = " + categoryId);
    }

    @DeleteMapping("/api/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        System.out.println("Delete category called: ID " + categoryId);
    }
}