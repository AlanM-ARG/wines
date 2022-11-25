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
    }


    public Set<Moment> getMoments() {
        return moments;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
