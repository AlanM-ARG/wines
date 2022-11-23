package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.ProductDTO;
import com.ecommerce.wines.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public List<ProductDTO> getProductsDTO(){
        return productService.getProductsDTO();
    }

}
