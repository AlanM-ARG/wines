package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.PaymentMethod;
import com.ecommerce.wines.models.Product;
import com.ecommerce.wines.models.PurchaseOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PurchaseOrderDTO {

    private long id;

    private Client client;

    private double mount;

    private LocalDateTime localDateTime;

    private PaymentMethod paymentMethod;

    private List<Product> products;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(PurchaseOrder purchaseOrder) {
        this.id = purchaseOrder.getId();
        this.client = purchaseOrder.getClient();
        this.mount = purchaseOrder.getMount();
        this.localDateTime = purchaseOrder.getLocalDateTime();
        this.paymentMethod = purchaseOrder.getPaymentMethod();
        this.products = purchaseOrder.getProducts();
    }

    public long getId() {
        return id;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Product> getProducts() {
        return products;
    }

}
