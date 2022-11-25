package com.ecommerce.wines.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    private double mount;

    @OneToMany(mappedBy="purchaseOrder", fetch= FetchType.EAGER)
    Set<Product> products = new HashSet<>();

    private LocalDateTime localDateTime;

    private PaymentMethod paymentMethod;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Client client, double mount, LocalDateTime localDateTime, PaymentMethod paymentMethod) {
        this.client = client;
        this.mount = mount;
        this.localDateTime = localDateTime;
        this.paymentMethod = paymentMethod;
    }


    public Set<Product> getProducts() {
        return products;
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

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", client=" + client +
                ", mount=" + mount +
                ", products=" + products +
                ", localDateTime=" + localDateTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
