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
import java.util.Set;
import java.util.stream.Collectors;

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

        List<Product> products = productService.getAllProducts();

        // valores vacios
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

        if(stock <=0){
            return new ResponseEntity<>("Invalid stock", HttpStatus.FORBIDDEN);
        }

        if(price <= 0){
            return new ResponseEntity<>("Invalid price", HttpStatus.FORBIDDEN);
        }

        if(category.toString().isEmpty()){
            return new ResponseEntity<>("Missing category", HttpStatus.FORBIDDEN);
        }

        //demas if

        if(products.stream().map(product -> product.getName()).collect(Collectors.toSet()).contains(name)){
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }


        Product product = new Product(category, name, description, stock,price , discount, img, variety, tastingNote,temperature, true);
        productService.saveProduct(product);
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }

    @PatchMapping("/products/stock")
    public ResponseEntity<?> changeStock(@RequestParam int stock, @RequestParam String name){

        if(name.isEmpty()){
            return new ResponseEntity<>("name is missing",HttpStatus.FORBIDDEN);
        }


        productService.changeStock(stock, name);
        return new ResponseEntity<>("Stock changed", HttpStatus.CREATED);
    }

    @DeleteMapping("/products/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam String name){
        Product product = productService.findByName(name);
        productService.deleteProduct(product);
        return new ResponseEntity<>("Product delete",HttpStatus.CREATED);
    }

    @PatchMapping("/products/delete")
    public ResponseEntity<?> disabledProduct(@RequestParam String name){
        Product product = productService.findByName(name);
        if(product == null){
            return new ResponseEntity<>("Product not found",HttpStatus.FORBIDDEN);
        }
        if(name.isEmpty()){
            return new ResponseEntity<>("Missing name",HttpStatus.FORBIDDEN);
        }
        product.setActive(false);
        productService.saveProduct(product);
        return new ResponseEntity<>("Product delete",HttpStatus.CREATED);
    }


    @PatchMapping("/products/modify")
    public ResponseEntity<?> modifyProduct(@RequestParam String name, @RequestParam int stock, @RequestParam String newName, @RequestParam double price,@RequestParam String variety,
                                           @RequestParam String tastingNotes, @RequestParam String temperature, @RequestParam String description, @RequestParam String img){

        Product product = productService.findByName(name);
        List<Product> products = productService.getAllProducts();

        if (name.isEmpty()){
            return new ResponseEntity<>("Name is missing",HttpStatus.FORBIDDEN);
        }
        if (stock < 0){
            return new ResponseEntity<>("Invalid Stock",HttpStatus.FORBIDDEN);
        }
        if (price <= 0){
            return new ResponseEntity<>("Invalid Price", HttpStatus.FORBIDDEN);
        }
        if (!products.stream().map(product1 -> product1.getName()).collect(Collectors.toSet()).contains(name)){
            return new ResponseEntity<>("The product does not exist", HttpStatus.FORBIDDEN);

        }
        if (products.stream().map(product1 -> product1.getName()).collect(Collectors.toSet()).contains(newName)){
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }
        if (newName.isEmpty()){
            newName = product.getName();
        }
        if (variety.isEmpty()){
            variety = product.getVariety();
        }
        if (tastingNotes.isEmpty()){
            tastingNotes = product.getTastingNote();
        }
        if (temperature.isEmpty()){
            temperature = product.getTemperature();
        }
        if (description.isEmpty()){
            description = product.getDescription();
        }
        if (img.isEmpty()){
            img = product.getImg();
        }


        product.setName(newName);
        product.setStock(stock);
        product.setPrice(price);
        product.setVariety(variety);
        product.setTastingNote(tastingNotes);
        product.setTemperature(temperature);
        product.setDescription(description);
        product.setImg(img);
        productService.saveProduct(product);


        return new ResponseEntity<>("Change saved", HttpStatus.CREATED);
    }





}
