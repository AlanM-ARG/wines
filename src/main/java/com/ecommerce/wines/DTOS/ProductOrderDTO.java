package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.ProductOrder;
import com.ecommerce.wines.models.PurchaseOrder;

public class ProductOrderDTO {

    private long id;
    private Integer quantity;
    private double amount;

    public ProductOrderDTO(ProductOrder productOrder) {
        this.id = productOrder.getId();
        this.quantity = productOrder.getQuantity();
        this.amount = productOrder.getAmount();
    }

    public long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }
}
