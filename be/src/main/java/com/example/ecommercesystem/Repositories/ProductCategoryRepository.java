package com.example.ecommercesystem.Repositories;

import com.example.ecommercesystem.Models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
