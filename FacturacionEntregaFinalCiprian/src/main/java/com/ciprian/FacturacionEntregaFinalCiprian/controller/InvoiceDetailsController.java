package com.ciprian.FacturacionEntregaFinalCiprian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.InvoiceDetails;
import com.ciprian.FacturacionEntregaFinalCiprian.service.InvoiceDetailsService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "api")
public class InvoiceDetailsController {
  @Autowired
  private InvoiceDetailsService invoiceDetailsService;

  @Operation(summary = "Get invoice details by ID", description = "Get invoice details by ID", tags = {
      "Invoice Details" })
  @GetMapping(value = "/invoice-details/{id}", produces = { "application/json" })
  public ResponseEntity<Optional<InvoiceDetails>> getInvoiceDetailsById(@PathVariable Long id) {
    Optional<InvoiceDetails> invoiceDetails = invoiceDetailsService.findInvoiceDetailsById(id);
    if (invoiceDetails.isPresent()) {
      return ResponseEntity.ok(invoiceDetails);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(summary = "Get all invoice details", description = "Get all invoice details", tags = { "Invoice Details" })
  @GetMapping(value = "/invoice-details/all", produces = { "application/json" })
  public ResponseEntity<Iterable<InvoiceDetails>> getInvoiceDetails() {
    return ResponseEntity.ok(invoiceDetailsService.findAll());
  }

  @Operation(summary = "Delete a invoice details by ID", description = "Delete a invoice details by ID", tags = {
      "Invoice Details" })
  @DeleteMapping(value = "/invoice-details/{id}", produces = { "application/json" })
  public ResponseEntity<Optional<InvoiceDetails>> deleteClientById(@PathVariable Long id) {
    Optional<InvoiceDetails> invoiceDetails = invoiceDetailsService.findInvoiceDetailsById(id);
    if (invoiceDetails.isPresent()) {
      return ResponseEntity.ok(invoiceDetails);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
