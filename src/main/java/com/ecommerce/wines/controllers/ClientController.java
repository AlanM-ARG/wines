package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.ClientDTO;
import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/client/create")
    public ResponseEntity<?> createClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String img
    ){
        if(clientService.clientFindByEmail(email) != null){
            return new ResponseEntity<>("Email in use",HttpStatus.FORBIDDEN);

        }

        if (firstName.isEmpty()){
            return new ResponseEntity<>("Missing firist name", HttpStatus.FORBIDDEN);
        }
        if (lastName.isEmpty()){
            return new ResponseEntity<>("Missing last name", HttpStatus.FORBIDDEN);
        }
        if (email.isEmpty()){
            return new ResponseEntity<>("Missing email", HttpStatus.FORBIDDEN);
        }
        if (password.isEmpty()){
            return new ResponseEntity<>("Missing password", HttpStatus.FORBIDDEN);
        }

        if (img.isEmpty()){
            return new ResponseEntity<>("Missing image", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(firstName,lastName,email,password,img);
        clientService.saveClient(client);

        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }

    @DeleteMapping("/client/delete")
    public ResponseEntity<String> deleteClient(@RequestParam String email){

        Client client = clientService.clientFindByEmail(email);
        clientService.deleteClient(client);

        return new ResponseEntity<>("Delete client",HttpStatus.CREATED);

    }



}
