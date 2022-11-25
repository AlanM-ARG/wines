package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.Moment;
import com.ecommerce.wines.models.Product;
import com.ecommerce.wines.models.PurchaseOrder;

import java.awt.*;
import java.util.Set;

public class ClientDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private  String password;

    private String image;

    private String token;

    private boolean active;

    private Set<PurchaseOrder> purchaseOrders;

    private Set<Moment> moments;


    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.image = client.getImage();
        this.active = client.isActive();
        this.purchaseOrders = client.getPurchaseOrders();
        this.moments = client.getMoments();
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

    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public Set<Moment> getMoments() {
        return moments;
    }
}
