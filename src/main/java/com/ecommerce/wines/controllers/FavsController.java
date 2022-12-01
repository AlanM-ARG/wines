package com.ecommerce.wines.controllers;


import com.ecommerce.wines.DTOS.FavsDTO;
import com.ecommerce.wines.models.Client;

import com.ecommerce.wines.models.Favs;
import com.ecommerce.wines.models.Product;

import com.ecommerce.wines.services.ClientService;

import com.ecommerce.wines.services.FavsService;
import com.ecommerce.wines.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FavsController {

    @Autowired
    FavsService favsService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    @PostMapping("/clients/favs")
    public ResponseEntity<?> addFavs(Authentication authentication, @RequestParam String name){

        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        Product product = productService.findByName(name);
        List<Product> allProducts = productService.getAllProducts();

        if(clientCurrent == null){
            return new ResponseEntity<>("unauthenticated client", HttpStatus.FORBIDDEN);
        }
        if(name.isEmpty()){
            return new ResponseEntity<>("Missing name", HttpStatus.FORBIDDEN);
        }
        if(!allProducts.stream().map(product1 -> product1.getName()).collect(Collectors.toList()).contains(name)){
            return new ResponseEntity<>("The product does not exist", HttpStatus.FORBIDDEN);
        }
        if(clientCurrent.getFavss().stream().map(favs -> favs.getName()).collect(Collectors.toSet()).contains(name)){
            return new ResponseEntity<>("You already own this favorite", HttpStatus.FORBIDDEN);
        }

        Favs favs = new Favs(product, clientCurrent, product.getName(), product.getImage());
        favsService.saveFavs(favs);
        clientCurrent.addFavs(favs);
        clientService.saveClient(clientCurrent);

        return new ResponseEntity<>("Add fav", HttpStatus.ACCEPTED);
    }

    @GetMapping("/clients/favs")
    public List<FavsDTO> getAll(Authentication authentication){
        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        return clientCurrent.getFavss().stream().map(favs -> new FavsDTO(favs)).collect(Collectors.toList());
    }

    @DeleteMapping("/clients/favs/delete")
    public ResponseEntity<?> deleteFav(Authentication authentication, @RequestParam int id){
        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        Favs favs = favsService.getFavById(id);
        if (clientCurrent == null){
            return new ResponseEntity<>("unauthenticated client", HttpStatus.FORBIDDEN);
        }
        if (!clientCurrent.getFavss().stream().map(favs1 -> favs1.getId()).collect(Collectors.toSet()).contains(favs.getId())){
            return new ResponseEntity<>("this favourite does not belong to you", HttpStatus.FORBIDDEN);
        }
        if(id <= 0){
            return new ResponseEntity<>("Missing id", HttpStatus.FORBIDDEN);
        }
        favsService.deleteFavs(favs);
        return new ResponseEntity<>("Favourite deleted", HttpStatus.ACCEPTED);
    }





}
