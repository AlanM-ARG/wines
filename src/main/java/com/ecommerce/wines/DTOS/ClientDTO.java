package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.*;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private  String password;

    private String image;

    private String token;

    private boolean active;

    private Set<PurchaseOrderDTO> purchaseOrders;

    private Set<MomentDTO> moments;

    private Set<FavsDTO> favs;

    public ClientDTO(Client client) {
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.image = client.getImage();
        this.active = client.isActive();
        this.purchaseOrders = client.getPurchaseOrders().stream().map(purchaseOrder -> new PurchaseOrderDTO(purchaseOrder)).collect(Collectors.toSet());
        this.moments = client.getMoments().stream().map(moment -> new MomentDTO(moment)).collect(Collectors.toSet());
        this.favs = client.getFavss().stream().map(fav -> new FavsDTO(fav)).collect(Collectors.toSet());
        this.token = client.getToken();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public String getToken() {
        return token;
    }

    public boolean isActive() {
        return active;
    }

    public Set<PurchaseOrderDTO> getPurchaseOrders() {
        return purchaseOrders;
    }

    public Set<MomentDTO> getMoments() {
        return moments;
    }

    public Set<FavsDTO> getFavs() {
        return favs;
    }
}
