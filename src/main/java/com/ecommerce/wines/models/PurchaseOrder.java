package com.ecommerce.wines.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    private double amount;



    private LocalDateTime localDateTime;

    private PaymentMethod paymentMethod;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Client client, double amount, LocalDateTime localDateTime, PaymentMethod paymentMethod) {
        this.client = client;
        this.amount = amount;
        this.localDateTime = localDateTime;
        this.paymentMethod = paymentMethod;
    }




    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setMount(double mount) {
        this.amount = mount;
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



    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", client=" + client +
                ", amount=" + amount +

                ", localDateTime=" + localDateTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
