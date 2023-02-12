package com.ntt.EconomyApp.controller;

import com.ntt.EconomyApp.dto.request.CreateCategoryRequestDTO;
import com.ntt.EconomyApp.dto.request.UpdateCategoryRequestDTO;
import com.ntt.EconomyApp.dto.response.*;
import com.ntt.EconomyApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping(value = "category")
public class CategoryController implements Serializable {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/get-all")
    public ResponseEntity getAllCategory(Pageable pageable) {

        PagingResponseDTO pagingResponseDTO = categoryService.getAllCategory(pageable);

        return new ResponseEntity<>(pagingResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{category-id}")
    public ResponseEntity getCategoryById(@PathVariable("category-id") Integer categoryId) {

        CategoryResponseDTO categoryResponse = this.categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO) {
        CategoryResponseDTO categoryResponseDTO = this.categoryService.createCategory(createCategoryRequestDTO);

        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{category-id}")
    public ResponseEntity updateCategory(@PathVariable("category-id") Integer categoryId,
                                        @RequestBody UpdateCategoryRequestDTO updateCategoryRequestDTO) {
        UpdateCategoryResponseDTO response = this.categoryService.updateCategory(categoryId, updateCategoryRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity deleteCategory(@PathVariable("category-id") Integer categoryId) {
        this.categoryService.deleteCategoryTemporarily(categoryId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{category-id}/products")
    public ResponseEntity getProductByCategoryId(@PathVariable("category-id") Integer categoryId) {
        ProductOfCategoryResponseDTO productOfCategoryResponseDTO = this.categoryService.getProductByCategoryId(categoryId);

        return new ResponseEntity<>(productOfCategoryResponseDTO, HttpStatus.OK);
    }
}