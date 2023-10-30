package com.ciprian.FacturacionEntregaFinalCiprian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.InvoiceDetails;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Long> {

}