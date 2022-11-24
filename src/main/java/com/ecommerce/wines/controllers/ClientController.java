package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.ClientDTO;
import com.ecommerce.wines.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/clients")
    public List<ClientDTO> getClientsDTO() {

        return clientService.getClientsDTO();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientDTO(@PathVariable Long id) {

        return clientService.getClientDTO(id);
    }



}