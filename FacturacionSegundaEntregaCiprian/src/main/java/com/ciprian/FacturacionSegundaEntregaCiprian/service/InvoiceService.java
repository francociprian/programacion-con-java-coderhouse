package com.ciprian.FacturacionSegundaEntregaCiprian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Invoice;
import com.ciprian.FacturacionSegundaEntregaCiprian.repository.InvoiceRepository;

@Service
public class InvoiceService {
  @Autowired
  private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) throws Exception {
    return invoiceRepository.save(invoice);
  }

    public List<Invoice> getAllInvoices() {
    List<Invoice> invoices = invoiceRepository.findAll();
    return invoices;
  }
  
    public Invoice getInvoiceById(Long id) {
    Optional<Invoice> invoice = invoiceRepository.findById(id);
    if (invoice.isPresent()) {
      return invoice.get();
    } else {
      return null;
    }
  }
}
