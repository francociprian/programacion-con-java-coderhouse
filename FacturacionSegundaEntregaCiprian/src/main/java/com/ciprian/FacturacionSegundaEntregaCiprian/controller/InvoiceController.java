package com.ciprian.FacturacionSegundaEntregaCiprian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Invoice;
import com.ciprian.FacturacionSegundaEntregaCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionSegundaEntregaCiprian.service.InvoiceService;

@RestController
@RequestMapping(path = "/api")
public class InvoiceController {

  @Autowired
  private InvoiceService invoiceService;

  @PostMapping(path = "/invoice")
  public ResponseEntity<Object> saveInvoice(@RequestBody Invoice invoice) {
    try {
      System.out.println(invoice);
      Invoice invoiceSaved = invoiceService.saveInvoice(invoice);
      return ResponseHandler.generateResponse(
          "Invoice saved",
          HttpStatus.OK,
          invoiceSaved);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/invoices")
  public ResponseEntity<Object> getAllClients() {
    try {
      List<Invoice> invoices = invoiceService.getAllInvoices();
      return ResponseHandler.generateResponse(
          "Invoices Found",
          HttpStatus.OK,
          invoices);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/invoice/{id}")
  public ResponseEntity<Object> getInvoiceById(@PathVariable Long id) {
    try {
      Invoice invoice = invoiceService.getInvoiceById(id);

      if (invoice != null) {
        return ResponseHandler.generateResponse(
            "Invoice found",
            HttpStatus.OK,
            invoice);
      } else {
        return ResponseHandler.generateResponse(
            "Invoice not found",
            HttpStatus.NOT_FOUND,
            null);
      }
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

}
