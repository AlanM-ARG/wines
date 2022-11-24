package com.ecommerce.wines.controllers;
import com.ecommerce.wines.DTOS.ClientDTO;
import com.ecommerce.wines.DTOS.ProductDTO;
import com.ecommerce.wines.models.Category;
import com.ecommerce.wines.models.Product;
import com.ecommerce.wines.models.PurchaseOrder;
import com.ecommerce.wines.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
        return productService.getProductsDTO();
    }

    @GetMapping("/product")
    public ProductDTO getProductDTO(@RequestParam String name) {
        return productService.getProductDTO(name);
    }


    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct(
            @RequestParam Category category,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam int stock,
            @RequestParam double price,
            @RequestParam double discount,
            @RequestParam String img,
            @RequestParam String variety,
            @RequestParam String tastingNote,
            @RequestParam String temperature ){

        if(name.isEmpty() || description.isEmpty() || img.isEmpty() || variety.isEmpty() || tastingNote.isEmpty() || temperature.isEmpty()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Product product = new Product(category, name, description, stock,price , discount, img, variety, tastingNote,temperature);
        productService.saveProduct(product);
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }

    @PatchMapping("/product/stock")
    ResponseEntity<?> changeStock(@RequestParam int stock, @RequestParam String name){

        if(name.isEmpty()){
            return new ResponseEntity<>("name is missing",HttpStatus.FORBIDDEN);
        }

        if(productService.getProductDTO(name) == null){
            return new ResponseEntity<>("product does not exist",HttpStatus.FORBIDDEN);
        }

        productService.changeStock(stock, name);
        return new ResponseEntity<>("Stock changed", HttpStatus.CREATED);


    }

    @DeleteMapping("/product/delete")
    ResponseEntity<String> deleteProduct(@RequestParam String name){
        Product product = productService.findByName(name);
        productService.deleteProduct(product);
        return new ResponseEntity<>("Product delete",HttpStatus.CREATED);

    }



}
