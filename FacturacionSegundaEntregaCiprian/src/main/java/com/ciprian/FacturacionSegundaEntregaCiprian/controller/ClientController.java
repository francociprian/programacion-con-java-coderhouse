package com.ciprian.FacturacionSegundaEntregaCiprian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciprian.FacturacionSegundaEntregaCiprian.entity.Client;
import com.ciprian.FacturacionSegundaEntregaCiprian.middleware.ResponseHandler;
import com.ciprian.FacturacionSegundaEntregaCiprian.service.ClientService;

@RestController
@RequestMapping(path = "/api")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping(path = "/client")
  public ResponseEntity<Object> postClient(@RequestBody Client client) {
    try {
      System.out.println(client);
      Client clientSaved = clientService.postClient(client);
      return ResponseHandler.generateResponse(
          "Client saved",
          HttpStatus.OK,
          clientSaved);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @DeleteMapping(path = "/client/{id}")
  public ResponseEntity<Object> deleteClientById(@PathVariable Long id) {
    try {
      boolean deleted = clientService.deleteClientById(id);

      if (deleted) {
        return ResponseHandler.generateResponse(
            "Client deleted successfully",
            HttpStatus.OK,
            null);
      } else {
        return ResponseHandler.generateResponse(
            "Client not found",
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

  @GetMapping(path = "/clients")
  public ResponseEntity<Object> getAllClients() {
    try {
      List<Client> clients = clientService.getAllClients();
      return ResponseHandler.generateResponse(
          "Clients",
          HttpStatus.OK,
          clients);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "/client/{id}")
  public ResponseEntity<Object> getClientById(@PathVariable Long id) {
    try {
      Client client = clientService.getClientById(id);

      if (client != null) {
        return ResponseHandler.generateResponse(
            "Client found",
            HttpStatus.OK,
            client);
      } else {
        return ResponseHandler.generateResponse(
            "Client not found",
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
