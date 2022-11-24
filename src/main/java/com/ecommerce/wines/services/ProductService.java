package com.ecommerce.wines.services;

import com.ecommerce.wines.DTOS.ProductDTO;
import com.ecommerce.wines.models.Product;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getProductsDTO();

    public ProductDTO getProductDTO(String name);

    public void saveProduct(Product product);

    public void changeStock(int stock, String name);

    public Product findByName(String name);

    public void deleteProduct(Product product);
}
