package com.ciprian.Facturacion.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {
    public Client() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_lastname")
    private String lastname;

    @Column(name = "client_docnumber")
    private String docnumber;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

    public Client(int id, String name, String lastname, String docnumber) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
