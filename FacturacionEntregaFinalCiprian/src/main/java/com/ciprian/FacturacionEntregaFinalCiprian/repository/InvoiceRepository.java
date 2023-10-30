package com.ciprian.FacturacionEntregaFinalCiprian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
