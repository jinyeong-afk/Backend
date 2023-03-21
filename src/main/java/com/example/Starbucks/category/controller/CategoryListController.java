package com.example.Starbucks.category.controller;

import com.example.Starbucks.category.dto.ResponseSearch;
import com.example.Starbucks.category.model.CategoryList;
import com.example.Starbucks.category.service.ICategoryListService;
import com.example.Starbucks.category.vo.RequestCategoryList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/categories/")
public class CategoryListController {

    private final ICategoryListService iCategoryListService;

    @Operation(summary = "카테고리 검색", description = "mainCategoryId, middleCategoryId에 따른 카테고리 검색", tags = {"검색"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = ResponseSearch.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/category")
    public ResponseEntity<List<ResponseSearch>> searchByCategories
            (@Param("main") Integer main,
             @Param("middle") Integer middle,
             @Param("pageNum") Integer pageNum,
             @PageableDefault(page = 1, size = 8, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(iCategoryListService.searchByCategory(main, middle, pageNum, pageable));
    }

    @Operation(summary = "키워드 검색", description = "캐시 저장하여 keyword 검색 결과 가져오기(JPQL 사용)", tags = {"검색"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = ResponseSearch.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/keyword")
    public ResponseEntity<List<Object>> searchKeyword
            (@Param("keyword") String keyword, @Param("pageNum") int pageNum, @PageableDefault(page = 1, size = 8, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(iCategoryListService.searchCache(keyword, pageNum, pageable));
    }

    @Operation(summary = "카테고리 리스트 추가", description = "mainCategoryId, middleCategoryId, productId에 따른 categoryList 추가", tags = {"관리자"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = CategoryList.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/add")
    public ResponseEntity<CategoryList> addCategoryList(@RequestBody RequestCategoryList requestCategoryList) {
        return ResponseEntity.ok(iCategoryListService.addCategoryList(requestCategoryList));
    }
}
