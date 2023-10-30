package com.ciprian.FacturacionEntregaFinalCiprian.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "INVOICE_DETAILS")
public class InvoiceDetails {
  public InvoiceDetails() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Invoice Detail ID", hidden = true)
  private Long id;

  @Schema(description = "Invoice Detail Amount", hidden = true)
  private Long amount;

  @Schema(description = "Invoice Price", hidden = true)
  private Double price;

  @Schema(description = "Product ID", hidden = true)
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "productId")
  private Product product;

  public InvoiceDetails(Long amount, Product product, Double price) {
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

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
