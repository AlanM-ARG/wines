package com.ecommerce.wines.DTOS;

import com.ecommerce.wines.models.Client;
import com.ecommerce.wines.models.ProductOrder;
import com.ecommerce.wines.models.PurchaseOrder;

public class ProductOrderDTO {

    private long id;
    private Long  productId;
    private Integer quantity;
    private Double amount;

    public ProductOrderDTO(Long productId, Integer quantity, Double amount) {
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public ProductOrderDTO(ProductOrder productOrder) {
        this.id = productOrder.getId();
        this.productId = productOrder.getProduct().getId();
        this.quantity = productOrder.getQuantity();
        this.amount = productOrder.getAmount();
    }

    public long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getAmount() {
        return amount;
    }
}
