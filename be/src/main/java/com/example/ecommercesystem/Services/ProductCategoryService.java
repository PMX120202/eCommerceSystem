package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Models.ProductCategory;
import com.example.ecommercesystem.Repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll(){
        return productCategoryRepository.findAll();
    }

    public ProductCategory findById(Integer id){
        return productCategoryRepository.findById(id).get();
    }
}
