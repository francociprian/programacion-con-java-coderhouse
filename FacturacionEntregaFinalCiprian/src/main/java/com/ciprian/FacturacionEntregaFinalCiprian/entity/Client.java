package com.ciprian.FacturacionEntregaFinalCiprian.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
  public Client() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Client ID", example = "1", hidden = true)
  @Column(name = "client_id")
  private Long id;

  @Schema(description = "Client Name", example = "Franco", requiredMode = Schema.RequiredMode.REQUIRED)
  @Column(name = "client_name")
  private String name;

  @Schema(description = "Client Lastname", example = "Ciprian", requiredMode = Schema.RequiredMode.REQUIRED)
  @Column(name = "client_lastname")
  private String lastname;

  @Schema(description = "Client Document Number", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
  @Column(name = "client_docnumber")
  private String docnumber;

  @JsonIgnore
  @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
  private List<Invoice> invoices;

  public Client(Long id, String name, String lastname, String docnumber) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.docnumber = docnumber;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getDocnumber() {
    return docnumber;
  }

  public void setDocnumber(String docnumber) {
    this.docnumber = docnumber;
  }

  public List<Invoice> getInvoices() {
    return invoices;
  }

  public void setInvoices(List<Invoice> invoices) {
    this.invoices = invoices;
  }
}
