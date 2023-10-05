package com.ciprian.FacturacionSegundaEntregaCiprian.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    public Product() {
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;
    @Column(name = "prod_description")
    private String description;
    @Column(name = "prod_code")
    private String code;
    @Column(name = "prod_stock")
    private int stock;
    @Column(name = "prod_price")
    private double price;

    @OneToMany
    @Column (name = "invoice_detail_id")
    private List<InvoiceDetail> invoiceDetails;

    public Product(Long id, String description, String code, int stock, Long price) {
        this.id = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}