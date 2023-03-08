package com.example.Starbucks.product.service;

import com.example.Starbucks.product.model.MainCategory;
import com.example.Starbucks.product.vo.RequestCategory;
import com.example.Starbucks.product.vo.ResponseCategoryList;
import com.example.Starbucks.product.vo.ResponsePage;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryListService {

    void addCategory(RequestCategory requestCategory);
    MainCategory getCategory(Integer categoryId);
    List<MainCategory> getAll();
    //List<CategoryTypeDto> getAllType(String categoryType) ;
    void updateCategory(MainCategory mainCategory);

    ResponsePage searchByCategory(Integer mainCategoryId, Integer middleCategoryInteger, Integer pageNum, Pageable pageable);

//    Page<ResponseCategoryList.categorySearchInfo> searchByNameOrDescription(String keyword, String keyword2, Integer pageNum, Pageable pageable);

    ResponsePage searchByNameOrDescription(String keyword, String keyword2, Integer pageNum, Pageable pageable);

    //List<String> getCategoryTypeName();
}