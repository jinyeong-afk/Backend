package com.example.Starbucks.product.controller;

import com.example.Starbucks.product.dto.CategoryDto;
import com.example.Starbucks.product.dto.CategoryTypeDto;
import com.example.Starbucks.product.model.Category;
import com.example.Starbucks.product.service.ICategoryService;
import com.example.Starbucks.product.vo.RequestCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService iCategoryService;

    @PostMapping("/add")
    public void addCategory(@RequestBody RequestCategory requestCategory){
        iCategoryService.addCategory(requestCategory);
    }

    @GetMapping("/get/{categoryId}")
    public Category getCategory(@PathVariable Integer categoryId){
        return iCategoryService.getCategory(categoryId);
    }

    @GetMapping("/get/all")
    public List<Category> getAllCategory(){
        return iCategoryService.getAll();
    }

    @GetMapping("/get/type/{type}")
    public List<CategoryTypeDto> getAllByType(@PathVariable String type){
        return iCategoryService.getAllByType(type);
    }

    @GetMapping("/typename")
    public List<String> getCategoryTypeNames(){
        return iCategoryService.getCategoryTypeNames();
    }
}
