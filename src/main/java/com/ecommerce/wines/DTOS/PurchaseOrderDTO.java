package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PurchaseOrderDTO {

    private long id;

    private Client client;

    private double amount;

    private LocalDateTime localDateTime;

    private PaymentMethod paymentMethod;

    private List<ProductOrderDTO> productOrders;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(PurchaseOrder purchaseOrder) {
        this.id = purchaseOrder.getId();
        this.client = purchaseOrder.getClient();
        this.amount = purchaseOrder.getAmount();
        this.localDateTime = purchaseOrder.getLocalDateTime();
        this.paymentMethod = purchaseOrder.getPaymentMethod();
        this.productOrders = purchaseOrder.getProductOrders().stream().map(productOrder -> new ProductOrderDTO(productOrder)).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<ProductOrderDTO> getProductOrders() {
        return productOrders;
    }
}
