package com.ciprian.FacturacionEntregaFinalCiprian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.InvoiceDetails;
import com.ciprian.FacturacionEntregaFinalCiprian.repository.InvoiceDetailsRepository;

import java.util.Optional;

@Service
public class InvoiceDetailsService {

  @Autowired
  private InvoiceDetailsRepository invoiceDetailsRepository;

  public InvoiceDetails save(InvoiceDetails invoiceDetails) {
    return invoiceDetailsRepository.save(invoiceDetails);
  }

  public void deleteClientById(Long id) {
    invoiceDetailsRepository.deleteById(id);
  }

  public Optional<InvoiceDetails> findInvoiceDetailsById(Long id) {
    return invoiceDetailsRepository.findById(id);
  }

  public Iterable<InvoiceDetails> findAll() {
    return invoiceDetailsRepository.findAll();
  }
}
