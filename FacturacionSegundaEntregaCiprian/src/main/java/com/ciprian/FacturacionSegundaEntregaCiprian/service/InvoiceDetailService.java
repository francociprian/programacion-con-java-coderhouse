package com.ciprian.FacturacionSegundaEntregaCiprian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.InvoiceDetail;
import com.ciprian.FacturacionSegundaEntregaCiprian.repository.InvoiceDetailRepository;

@Service
public class InvoiceDetailService {
  @Autowired
  private InvoiceDetailRepository invoiceDetailRepository;

  public InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
    return invoiceDetailRepository.save(invoiceDetail);
  }

  public InvoiceDetail getInvoiceById(Long id) {
    Optional<InvoiceDetail> invoiceDetail = invoiceDetailRepository.findById(id);
    if (invoiceDetail.isPresent()) {
      return invoiceDetail.get();
    } else {
      return null;
    }
  }

  public List<InvoiceDetail> getAllInvoicesDetails() {
    List<InvoiceDetail> allInvoiceDetail = invoiceDetailRepository.findAll();
    return allInvoiceDetail;
  }

}
