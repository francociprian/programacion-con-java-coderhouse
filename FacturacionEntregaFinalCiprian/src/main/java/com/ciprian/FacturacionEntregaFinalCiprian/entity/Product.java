package com.ciprian.FacturacionEntregaFinalCiprian.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "PRODUCT")
public class Product {
  public Product() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Product ID", example = "1", hidden = true)
  private Long productId;

  @Schema(description = "Product Description", example = "Iphone 15", requiredMode = Schema.RequiredMode.REQUIRED)
  private String description;

  @Schema(description = "Product Code", example = "A00321", requiredMode = Schema.RequiredMode.REQUIRED)
  private String code;

  @Schema(description = "Product Stock", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
  private Long stock;

  @Schema(description = "Product Price", example = "1400", requiredMode = Schema.RequiredMode.REQUIRED)
  private double price;

  @OneToMany(mappedBy = "product")
  @JsonIgnore
  @Schema(description = "Invoice Details", requiredMode = Schema.RequiredMode.REQUIRED)
  private List<InvoiceDetails> invoiceDetails;

  public Product(Long id, String description, String code, Long stock, double price) {
    this.productId = id;
    this.description = description;
    this.code = code;
    this.stock = stock;
    this.price = price;
  }

  // Getters and setters
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
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

  public Long getStock() {
    return stock;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<InvoiceDetails> getInvoiceDetails() {
    return invoiceDetails;
  }

  public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
    this.invoiceDetails = invoiceDetails;
  }
}