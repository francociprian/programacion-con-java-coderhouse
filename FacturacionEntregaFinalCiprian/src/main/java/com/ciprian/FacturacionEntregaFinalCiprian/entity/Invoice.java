package com.ciprian.FacturacionEntregaFinalCiprian.entity;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "INVOICE")
public class Invoice {
  public Invoice() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Schema(description = "Invoice ID", hidden = true)
  private Long invoiceId;

  @Column(name = "create_at")
  @Schema(description = "Creation date", example = "2024-01-01 01:30:10")
  private Date createdAt;

  @Column(name = "total")
  @Schema(description = "Total Price", example = "300.00")
  private Double total;

  @Column(name = "total_product")
  @Schema(description = "Total Products", example = "2")
  private int totalProduct;

  @ManyToOne(cascade = CascadeType.MERGE)
  @Schema(description = "Client ID", hidden = true)
  @JoinColumn(name = "clientId")
  private Client client;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @Schema(description = "Invoice Details", requiredMode = Schema.RequiredMode.REQUIRED)
  private List<InvoiceDetails> invoiceDetails;

  public Invoice(Long id, Client client, Date createdAt, double total, int totalProduct) {
    this.invoiceId = id;
    this.client = client;
    this.createdAt = createdAt;
    this.total = total;
    this.totalProduct = totalProduct;
  }

  // Getters and setters
  public Long getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(Long invoiceId) {
    this.invoiceId = invoiceId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public List<InvoiceDetails> getInvoiceDetails() {
    return invoiceDetails;
  }

  public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
    this.invoiceDetails = invoiceDetails;
  }

  public void setTotalProduct(int totalProduct) {
    this.totalProduct = totalProduct;
  }

  public int getTotalProduct() {
    return totalProduct;
  }
}
