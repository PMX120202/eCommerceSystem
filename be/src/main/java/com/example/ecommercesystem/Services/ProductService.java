package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Exceptions.ProductNotFoundException;
import com.example.ecommercesystem.Models.Product;
import com.example.ecommercesystem.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id){
        return productRepository
                .findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
