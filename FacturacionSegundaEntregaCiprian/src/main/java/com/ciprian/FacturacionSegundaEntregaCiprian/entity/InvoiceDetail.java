package com.ciprian.FacturacionSegundaEntregaCiprian.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INVOICE_DETAIL")
public class InvoiceDetail {
    public InvoiceDetail() {
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invc_detail_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invc_detail_invc_id")
    private Invoice invoice;

    @Column(name = "invc_detail_amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "invc_detail_prod_id")
    private Product product;

    @Column(name = "invc_detail_price")
    private double price;

    public InvoiceDetail(Long id, Invoice invoice, int amount, Product product, double price) {
        this.id = id;
        this.invoice = invoice;
        this.amount = amount;
        this.product = product;
        this.price = price;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}