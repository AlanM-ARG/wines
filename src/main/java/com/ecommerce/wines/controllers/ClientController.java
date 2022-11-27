package com.ecommerce.wines.controllers;

import com.ecommerce.wines.DTOS.ClientDTO;
import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.services.ClientService;
import com.ecommerce.wines.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/clients")
    public List<ClientDTO> getClientsDTO() {
        return clientService.getClientsDTO();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientDTO(@PathVariable Long id) {
        return clientService.getClientDTO(id);
    }

    @PostMapping("/clients/create")
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

        String token = UUID.randomUUID().toString();

        Client client = new Client(firstName,lastName,email,passwordEncoder.encode(password),img,token,false);

        clientService.saveClient(client);

        String link = "http://localhost:8080/api/clients/confirm/" + token;

        emailService.sendEmail(client.getEmail(), "Confirm you Email", "Click on the following link to confirm your account " + link);

        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }

    @GetMapping("/clients/confirm/{token}")
    public ResponseEntity<?> confirmClient (@PathVariable String token, HttpServletResponse response) throws IOException {

        Client client = clientService.findByToken(token);

        client.setActive(true);

        clientService.saveClient(client);

        response.sendRedirect("/web/pages/login-register.html?confirmed=true");

        return new ResponseEntity<>("confirmed", HttpStatus.OK);
    }

    @PatchMapping("/clients/delete")
    public ResponseEntity<?> disabledClient(@RequestParam String email){

        Client clientCurrent = clientService.clientFindByEmail(email);
        if(clientCurrent == null){
            return new ResponseEntity<>("unauthenticated client", HttpStatus.FORBIDDEN);
        }
        if(email.isEmpty()){
            return new ResponseEntity<>("Missing email", HttpStatus.FORBIDDEN);
        }
        clientCurrent.setActive(false);
        clientService.saveClient(clientCurrent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/clients/current")
    public ClientDTO getAuthenticationClient(Authentication authentication){
        return  new ClientDTO(clientService.clientFindByEmail(authentication.getName()));
    }

    @PatchMapping("/clients/current/changePassword")
    public ResponseEntity<?> changePassword(Authentication authentication, @RequestParam String password){
        Client clientCurrent = clientService.clientFindByEmail(authentication.getName());
        clientCurrent.setPassword(passwordEncoder.encode(password));
        clientService.saveClient(clientCurrent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
