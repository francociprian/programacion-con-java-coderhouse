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

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.InvoiceDetail;
import com.ciprian.FacturacionSegundaEntregaCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionSegundaEntregaCiprian.service.InvoiceDetailService;

@RestController
@RequestMapping(value = "/api")
public class InvoiceDetailController {

  @Autowired
  private InvoiceDetailService invoiceDetailService;

  @PostMapping(path = "/invoice-detail")
  public ResponseEntity<Object> saveInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail) {
    try {
      System.out.println(invoiceDetail);
      InvoiceDetail InvoiceDetailSaved = invoiceDetailService.saveInvoiceDetail(invoiceDetail);
      return ResponseHandler.generateResponse(
          "Invoice Detail saved",
          HttpStatus.OK,
          InvoiceDetailSaved);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/invoices-details")
  public ResponseEntity<Object> getAllInvoicesDetails() {
    try {
      List<InvoiceDetail> InvoiceDetails = invoiceDetailService.getAllInvoicesDetails();
      return ResponseHandler.generateResponse(
          "Invoice Detail",
          HttpStatus.OK,
          InvoiceDetails);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/invoice-detail/{id}")
  public ResponseEntity<Object> getInvoiceById(@PathVariable Long id) {
    try {
      InvoiceDetail invoiceDetail = invoiceDetailService.getInvoiceById(id);

      if (invoiceDetail != null) {
        return ResponseHandler.generateResponse(
            "Invoice Detail found",
            HttpStatus.OK,
            invoiceDetail);
      } else {
        return ResponseHandler.generateResponse(
            "Invoice Detail not found",
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
