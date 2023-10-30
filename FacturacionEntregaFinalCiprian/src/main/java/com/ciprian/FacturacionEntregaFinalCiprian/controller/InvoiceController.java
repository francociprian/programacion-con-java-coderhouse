package com.ciprian.FacturacionEntregaFinalCiprian.controller;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ciprian.FacturacionEntregaFinalCiprian.entity.Invoice;
import com.ciprian.FacturacionEntregaFinalCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionEntregaFinalCiprian.service.InvoiceService;

@RestController
@RequestMapping("api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Operation(summary = "Create Invoice with Details", description = "Creates an invoice with client and details.", tags = {
            "Invoice" })
    @PostMapping(path = "/invoice", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> saveInvoiceWithDetails(@RequestBody Invoice invoice) {
        try {
            System.out.println(invoice);
            Invoice response = invoiceService.saveInvoice(invoice);
            return ResponseHandler.generateResponse(
                    "Invoice saved",
                    HttpStatus.OK,
                    response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @Operation(summary = "Get a invoice by ID", description = "Get a invoice by ID", tags = { "Invoice" })
    @GetMapping(value = "/invoice/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getInvoiceById(@PathVariable Long id) {
        try {
            Invoice invoice = invoiceService.findInvoiceById(id);

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

    @Operation(summary = "Get all Invoices", description = "Get all Invoices", tags = { "Invoice" })
    @GetMapping(value = "/invoice/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getInvoices() {
        try {
            Iterable<Invoice> invoices = invoiceService.findAll();
            return ResponseHandler.generateResponse(
                    "All Invoices",
                    HttpStatus.OK,
                    invoices);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @Operation(summary = "Delete a invoice by ID", description = "Delete a invoice by ID", tags = { "Invoice" })
    @DeleteMapping(path = "/invoice/{id}")
    public ResponseEntity<Object> deleteInvoiceById(@PathVariable Long id) {
        try {
            boolean deleted = invoiceService.deleteInvoice(id);

            if (deleted) {
                return ResponseHandler.generateResponse(
                        "Invoice deleted successfully",
                        HttpStatus.OK,
                        null);
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
