package com.ciprian.Facturacion.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    public Invoice() {
        super();
    }

    public Invoice(int id, Client client_id, Date created_at, long total) {
        super();
        this.id = id;
        this.ClientId = client_id;
        this.created_at = created_at;
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invc_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "invc_client_id")
    private Client ClientId;

    @Column(name = "invc_created_at")
    private Date created_at;

    @Column(name = "invc_total")
    private long total;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return ClientId;
    }

    public void setClient(Client client) {
        this.ClientId = client;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}