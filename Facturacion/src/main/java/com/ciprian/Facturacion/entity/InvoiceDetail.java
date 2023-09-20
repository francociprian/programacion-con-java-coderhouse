package com.ciprian.Facturacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVOICE_DETAIL")
public class InvoiceDetail {
    public InvoiceDetail() {
        super();
    }

    public InvoiceDetail(int id, Invoice invoice, int amount, Product product, Long price) {
        super();
        this.id = id;
        this.invoice = invoice;
        this.amount = amount;
        this.product = product;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invc_detail_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "invc_detail_invc_id")
    private Invoice invoice;

    @Column(name = "invc_detail_amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "invc_detail_prod_id")
    private Product product;

    @Column(name = "invc_detail_price")
    private Long price;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}