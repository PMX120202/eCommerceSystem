package com.example.ecommercesystem.Controllers;

import com.example.ecommercesystem.DTO.ResponseClient;
import com.example.ecommercesystem.DTO.ResponseData;
import com.example.ecommercesystem.DTO.ResponseListData;
import com.example.ecommercesystem.DTO.ResponseMessage;
import com.example.ecommercesystem.Exceptions.ProductNotFoundException;
import com.example.ecommercesystem.Models.Product;
import com.example.ecommercesystem.Models.ProductCategory;
import com.example.ecommercesystem.Repositories.ProductCategoryRepository;
import com.example.ecommercesystem.Services.ProductCategoryService;
import com.example.ecommercesystem.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/products")
    public ResponseEntity<ResponseClient> getAllProducts(){
        List<Product> products = productService.findAll();

        if(products.isEmpty()){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(1, "Product not exist"));
        }

        return ResponseEntity
                .ok(new ResponseListData<Product>(0, products));
    }

    @GetMapping("/products/category")
    public ResponseEntity<ResponseClient> getProductByCategory(){
        List<ProductCategory> productCategoryList = productCategoryService.findAll();

        return ResponseEntity
                .ok(new ResponseListData<ProductCategory>(0, productCategoryList));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseClient> getProductById(@PathVariable Integer id){
        Product product = productService.findById(id);

//        if(product == null){
//            return ResponseEntity
//                    .badRequest()
//                    .body(new ResponseMessage(1, "Product not found"));
//        }

        return ResponseEntity.ok(new ResponseData<Product>(0, product));
    }
}
