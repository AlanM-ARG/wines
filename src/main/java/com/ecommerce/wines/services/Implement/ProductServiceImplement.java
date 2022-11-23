package com.ecommerce.wines.services.Implement;

import com.ecommerce.wines.DTOS.ProductDTO;
import com.ecommerce.wines.repositories.ProductRepository;
import com.ecommerce.wines.services.ProductService;
import com.ecommerce.wines.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductsDTO() {
        return productRepository.findAll().stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }
}
