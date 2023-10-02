package com.ciprian.ClienteApiRest.controller;

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

import com.ciprian.ClienteApiRest.entity.Client;
import com.ciprian.ClienteApiRest.entity.ClientByAge;
import com.ciprian.ClienteApiRest.middleware.ResponseHandler;
import com.ciprian.ClienteApiRest.service.ClientService;

@RestController
@RequestMapping(path = "/api/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping
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

  @GetMapping(path = "{id}")
  public ResponseEntity<Object> getClient(@PathVariable() int id) {
    try {
      System.out.println(id);
      ClientByAge clientFound = clientService.getClient(id);
      return ResponseHandler.generateResponse(
          "Client found",
          HttpStatus.OK,
          clientFound);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  @GetMapping(path = "all")
  public ResponseEntity<Object> getAllClients() {
    try {
      List<Client> clients = clientService.getAllClients();
      return ResponseHandler.generateResponse(
          "All Clients",
          HttpStatus.OK,
          clients);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }
}