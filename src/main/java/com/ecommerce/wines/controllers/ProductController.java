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


    @RequestMapping("/products/{id}")
    public ProductDTO getProductDTO(@PathVariable Long id) {
        return productService.getProductDTO(id);
    }


    @PostMapping("/products/create")
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

        if(name.isEmpty()){
            return new ResponseEntity<>("Missing name", HttpStatus.FORBIDDEN);
        }

        if(description.isEmpty()){
            return new ResponseEntity<>("Missing description", HttpStatus.FORBIDDEN);
        }

        if(img.isEmpty()){
            return new ResponseEntity<>("Missing img", HttpStatus.FORBIDDEN);
        }

        if(variety.isEmpty()){
            return new ResponseEntity<>("Missing variety", HttpStatus.FORBIDDEN);
        }

        if(tastingNote.isEmpty()){
            return new ResponseEntity<>("Missing tasting note", HttpStatus.FORBIDDEN);
        }

        if(temperature.isEmpty()){
            return new ResponseEntity<>("Missing temperature", HttpStatus.FORBIDDEN);
        }


        Product product = new Product(category, name, description, stock,price , discount, img, variety, tastingNote,temperature);
        productService.saveProduct(product);
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }

    @PatchMapping("/products/stock")
    ResponseEntity<?> changeStock(@RequestParam int stock, @RequestParam String name){

        if(name.isEmpty()){
            return new ResponseEntity<>("name is missing",HttpStatus.FORBIDDEN);
        }


        productService.changeStock(stock, name);
        return new ResponseEntity<>("Stock changed", HttpStatus.CREATED);


    }

    @DeleteMapping("/products/delete")
    ResponseEntity<String> deleteProduct(@RequestParam String name){
        Product product = productService.findByName(name);
        productService.deleteProduct(product);
        return new ResponseEntity<>("Product delete",HttpStatus.CREATED);

    }



}
