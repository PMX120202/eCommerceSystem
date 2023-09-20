package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Models.Product;
import com.example.ecommercesystem.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id){
        return productRepository
                .findById(id);
    }
}
