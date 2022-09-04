/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.service.impl;

import com.tat.pojo.Category;
import com.tat.repository.CategoryRepository;
import com.tat.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dts
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getCategories() {
         return this.categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(int cateId) {
        return this.categoryRepository.getCategoryById(cateId);
    }
}
