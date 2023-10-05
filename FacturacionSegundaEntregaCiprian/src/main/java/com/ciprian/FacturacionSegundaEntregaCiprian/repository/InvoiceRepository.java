package com.ciprian.FacturacionSegundaEntregaCiprian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Invoice;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Long>{
  
}
